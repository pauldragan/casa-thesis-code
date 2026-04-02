package thesis.evaluation.version3.me;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class CvssCatalogV3Tests {
    private CvssCatalogV3Tests() {
    }

    public static void runAll() {
        TestSupportV3.run("me.CvssCatalogV3.loadsRequiredEntryFields",
                CvssCatalogV3Tests::loadsRequiredEntryFields);
        TestSupportV3.run("me.CvssCatalogV3.acceptsConsistentDuplicateCveEntries",
                CvssCatalogV3Tests::acceptsConsistentDuplicateCveEntries);
    }

    private static void loadsRequiredEntryFields() {
        CvssCatalogV3.Entry entry = CvssCatalogV3.defaults().getRequired("CVE-2024-7347");
        TestSupportV3.equals("CVE-2024-7347", entry.cveId(), "Catalog should load entries by CVE id");
        TestSupportV3.check(!entry.attackVector().isBlank(), "Catalog should expose attack vector");
        TestSupportV3.check(!entry.attackComplexity().isBlank(), "Catalog should expose attack complexity");
        TestSupportV3.check(!entry.privilegesRequired().isBlank(), "Catalog should expose privileges required");
        TestSupportV3.check(!entry.scope().isBlank(), "Catalog should expose scope");
    }

    private static void acceptsConsistentDuplicateCveEntries() {
        CvssCatalogV3.Entry entry = CvssCatalogV3.defaults().getRequired("CVE-2024-27983");
        TestSupportV3.equals("CVE-2024-27983", entry.cveId(), "Catalog should resolve CVEs with consistent duplicate rows");
    }
}
