from dataclasses import dataclass
from random import Random
from statistics import mean, median, stdev
import sys
import math

from self_adaptation_cases import (
    SELF_ADAPTATION_CASES,
    SelfAdaptationModelContext,
    SelfAdaptationResult,
    simulate_self_adaptation_case,
)


DEFAULT_N_MODELS = 50000
RANDOM_SEED = 42


@dataclass(frozen=True)
class SamplingRange:
    minimum: int
    maximum: int


@dataclass(frozen=True)
class ModelResult:
    class_instances: int
    relations: int
    num_data_subjects: int
    num_functions: int
    num_components: int

    @property
    def connectivity(self) -> float:
        return self.relations / self.class_instances

MODEL_DS_RANGES = {
    "DSUser": SamplingRange(1, 265),
    "DSModerator": SamplingRange(1, 30),
    "DSAdministrator": SamplingRange(1, 3),
}

MODEL_F_RANGES = {
    "FliveStreamVideo": SamplingRange(0, 5),
    "FP2PStreaming": SamplingRange(0, 5),
    "FRecommendVideos": SamplingRange(0, 5),
    "FserveStandardAds": SamplingRange(0, 5),
    "FServeLocationTargetedAds": SamplingRange(0, 5),
    "FServeBehaviorTargetedAds": SamplingRange(0, 5),
    "FUploadVideo": SamplingRange(1, 5),
    "FStreamVideo": SamplingRange(1, 5),
    "FRemoveVideo": SamplingRange(1, 5),
    "FComments": SamplingRange(1, 5),
}

MODEL_C_RANGES = {
    "Cnginx": SamplingRange(1, 20),
    "CexpressJS": SamplingRange(1, 20),
    "Cpostgresql": SamplingRange(1, 20),
    "CangularSPA": SamplingRange(1, 20),
    "Credis": SamplingRange(1, 20),
    "Cfilesystem": SamplingRange(1, 20),
}

MODEL_PD_PER_DS_RANGES = {
    "PDUsername": SamplingRange(1, 5),
    "PDPassword": SamplingRange(1, 5),
    "PDEmail": SamplingRange(1, 5),
    "PDPaymentDetails": SamplingRange(0, 5),
    "PDTrackingCookie": SamplingRange(0, 5),
    "PDStreamingHistory": SamplingRange(0, 5),
    "PDUploadedVideo": SamplingRange(0, 5),
    "PDComment": SamplingRange(0, 5),
    "PDVideoMetadata": SamplingRange(0, 5),
    "PDDeviceType": SamplingRange(0, 5),
    "PDDeviceLocation": SamplingRange(0, 5),
    "PDRequestTimestamp": SamplingRange(0, 5),
}

MODEL_RELATIONS_PER_F_RANGES = {
    "realizes": SamplingRange(1, 6),
    "realizedBy": SamplingRange(1, 6),
    "processes": SamplingRange(1, 14),
    "processedBy": SamplingRange(1, 14),
    "hasPurpose": SamplingRange(1, 14),
    "ofFunction": SamplingRange(1, 14),
}

MODEL_RELATIONS_PER_PD_RANGES = {
    "identifies": SamplingRange(1, 1),
    "identifiedBy": SamplingRange(1, 1),
}


def sample(rng: Random, r: SamplingRange) -> int:
    return rng.randint(r.minimum, r.maximum)


def sample_relation_count(
    rng: Random,
    instance_count: int,
    relation_ranges: dict[str, SamplingRange],
) -> int:
    return sum(
        sum(sample(rng, r) for r in relation_ranges.values())
        for _ in range(instance_count)
    )


def percentile(sorted_values: list[float], p: float) -> float:
    index = p * (len(sorted_values) - 1)
    lower = math.floor(index)
    upper = math.ceil(index)

    if lower == upper:
        return sorted_values[lower]

    weight = index - lower
    return sorted_values[lower] * (1 - weight) + sorted_values[upper] * weight


def print_statistics(name: str, values: list[float]) -> None:
    sorted_values = sorted(values)

    print()
    print(name)
    print("-" * len(name))
    print(f"Mean:              {mean(values):,.2f}")
    print(f"Median:            {median(values):,.2f}")
    print(f"Std. deviation:    {stdev(values):,.2f}")
    print(f"5th percentile:    {percentile(sorted_values, 0.05):,.2f}")
    print(f"25th percentile:   {percentile(sorted_values, 0.25):,.2f}")
    print(f"75th percentile:   {percentile(sorted_values, 0.75):,.2f}")
    print(f"95th percentile:   {percentile(sorted_values, 0.95):,.2f}")
    print(f"Observed minimum:  {min(values):,.2f}")
    print(f"Observed maximum:  {max(values):,.2f}")


def simulate_model(rng: Random) -> ModelResult:
    ds_count = sum(sample(rng, r) for r in MODEL_DS_RANGES.values())
    f_count = sum(sample(rng, r) for r in MODEL_F_RANGES.values())
    c_count = sum(sample(rng, r) for r in MODEL_C_RANGES.values())

    pd_count = 0
    for _ in range(ds_count):
        pd_count += sum(sample(rng, r) for r in MODEL_PD_PER_DS_RANGES.values())

    class_instances = ds_count + f_count + c_count + pd_count

    f_relations = sample_relation_count(
        rng,
        instance_count=f_count,
        relation_ranges=MODEL_RELATIONS_PER_F_RANGES,
    )

    pd_relations = sample_relation_count(
        rng,
        instance_count=pd_count,
        relation_ranges=MODEL_RELATIONS_PER_PD_RANGES,
    )

    return ModelResult(
        class_instances=class_instances,
        relations=f_relations + pd_relations,
        num_data_subjects=ds_count,
        num_functions=f_count,
        num_components=c_count,
    )


def parse_n_models() -> int:
    if len(sys.argv) < 2:
        return DEFAULT_N_MODELS

    return int(sys.argv[1])


def main() -> None:
    rng = Random(RANDOM_SEED)
    n_models = parse_n_models()

    model_results: list[ModelResult] = []
    self_adaptation_results: list[SelfAdaptationResult] = []

    for _ in range(n_models):
        model = simulate_model(rng)
        model_results.append(model)

        case_model_context = SelfAdaptationModelContext(
            num_data_subjects=model.num_data_subjects,
            num_functions=model.num_functions,
            num_components=model.num_components,
        )

        for case in SELF_ADAPTATION_CASES:
            self_adaptation_results.append(
                simulate_self_adaptation_case(rng, case_model_context, case)
            )

    print(f"Generated models:           {len(model_results):,}")
    print(f"Generated self-adaptations:  {len(self_adaptation_results):,}")

    print_statistics("Generated model class instances", [r.class_instances for r in model_results])
    print_statistics("Generated model relations", [r.relations for r in model_results])
    print_statistics("Generated model connectivity", [r.connectivity for r in model_results])

    print_statistics("Self-adaptation added functions", [r.added_functions for r in self_adaptation_results])
    print_statistics("Self-adaptation removed functions", [r.removed_functions for r in self_adaptation_results])
    print_statistics("Self-adaptation added components", [r.added_components for r in self_adaptation_results])
    print_statistics("Self-adaptation removed components", [r.removed_components for r in self_adaptation_results])
    print_statistics(
        "Self-adaptation consent violations due to incompatible purposes",
        [r.consent_violations_incompatible_purposes for r in self_adaptation_results],
    )
    print_statistics(
        "Self-adaptation consent violations due to increased risk",
        [r.consent_violations_increased_risk for r in self_adaptation_results],
    )
    print_statistics(
        "Self-adaptation total consent violations",
        [r.total_consent_violations for r in self_adaptation_results],
    )

    print_statistics(
        "Self-adaptation added-function relations",
        [r.added_function_relations for r in self_adaptation_results],
    )
    print_statistics(
        "Self-adaptation removed-function relations",
        [r.removed_function_relations for r in self_adaptation_results],
    )
    print_statistics(
        "Self-adaptation added-component relations",
        [r.added_component_relations for r in self_adaptation_results],
    )
    print_statistics(
        "Self-adaptation total added relations",
        [r.total_added_relations for r in self_adaptation_results],
    )
    print_statistics(
        "Self-adaptation total removed relations",
        [r.total_removed_relations for r in self_adaptation_results],
    )
    print_statistics(
        "Self-adaptation total relations",
        [r.total_relations for r in self_adaptation_results],
    )


if __name__ == "__main__":
    main()
