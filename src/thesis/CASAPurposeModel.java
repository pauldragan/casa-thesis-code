package thesis;

import java.io.File;

import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

public class CASAPurposeModel {

	private final OWLOntologyManager manager;
	private final OWLOntology ontology;
	private final OWLReasoner reasoner;
	private final OWLDataFactory dataFactory;
	
	public enum PurposeRelation {
		SPECIALIZATION,
		GENERALIZATION,
		SAME,
		NONE
	}

	public CASAPurposeModel(String ontologyPath) {
		manager = OWLManager.createOWLOntologyManager();
		File owx = new File(ontologyPath);
		try {
			ontology = manager.loadOntologyFromOntologyDocument(owx);
			reasoner = new Reasoner.ReasonerFactory().createReasoner(ontology);
			dataFactory = manager.getOWLDataFactory();

//			OWLClass myClass = dataFactory.getOWLClass(
//					IRI.create("http://www.semanticweb.org/paul/ontologies/2025/1/casa-swim-purpose-model#Marketing"));
//			NodeSet<OWLClass> classes = reasoner.getSubClasses(myClass, false);
//
//			for (OWLClass c : classes.entities().toList()) {
//				System.out.println("Class: " + c);
//			}
		} catch (OWLOntologyCreationException e) {
			System.out.println("Failed to create CASAPurposeModel!");
			// e.printStackTrace();
			throw new RuntimeException("Failed to create CASAPurposeModel!");
		}

	}
	
	public PurposeRelation calculatePurposeRelation(String purposeA, String purposeB) throws RuntimeException {
		OWLClass PA = dataFactory.getOWLClass(
				IRI.create("http://www.semanticweb.org/paul/ontologies/2025/1/casa-swim-purpose-model#" + purposeA));
		OWLClass PB = dataFactory.getOWLClass(
				IRI.create("http://www.semanticweb.org/paul/ontologies/2025/1/casa-swim-purpose-model#" + purposeB));
			
		NodeSet<OWLClass> paSubclasses = reasoner.getSubClasses(PA);
		NodeSet<OWLClass> pbSubclasses = reasoner.getSubClasses(PB);
		
		if (pbSubclasses.containsEntity(PA)) { // Check if PA is a specialization of PB
			return PurposeRelation.SPECIALIZATION;
		} else if (paSubclasses.containsEntity(PB)) { // Check if PA is a generalization of PB
			return PurposeRelation.GENERALIZATION;
		} else if (reasoner.getEquivalentClasses(PA).contains(PB)) { // Check if PA and PB are the same
			return PurposeRelation.SAME;
		}
		
		return PurposeRelation.NONE; 
	}

}
