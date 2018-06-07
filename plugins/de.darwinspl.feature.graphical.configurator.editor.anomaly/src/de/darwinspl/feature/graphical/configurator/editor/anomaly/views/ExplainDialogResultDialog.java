package de.darwinspl.feature.graphical.configurator.editor.anomaly.views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import de.darwinspl.anomalies.explanations.AnomalyConstraintExplanation;
import de.darwinspl.anomaly.DwAnomaly;
import de.darwinspl.anomaly.DwDeadFeatureAnomaly;
import de.darwinspl.anomaly.DwFalseOptionalFeatureAnomaly;
import de.darwinspl.anomaly.DwVoidFeatureModelAnomaly;
import eu.hyvar.context.contextValidity.HyValidityFormula;
import eu.hyvar.context.information.contextValue.HyContextValue;
import eu.hyvar.dataValues.HyEnumValue;
import eu.hyvar.dataValues.HyNumberValue;
import eu.hyvar.dataValues.HyStringValue;
import eu.hyvar.feature.HyRootFeature;
import eu.hyvar.feature.constraint.HyConstraint;

public class ExplainDialogResultDialog extends TitleAreaDialog {

	Text uriText;

	private final DwAnomaly anomaly;
	private final Set<AnomalyConstraintExplanation> anomalyExplanation;

	public ExplainDialogResultDialog(Shell parentShell, DwAnomaly anomaly,
			Set<AnomalyConstraintExplanation> anomalyExplanation) {
		super(parentShell);
		this.anomaly = anomaly;
		this.anomalyExplanation = anomalyExplanation;
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Explanation of an anomaly");
		setMessage("The explanation is given as a list of anomaly causing constraints below.",
				IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		// create new layout data to span the w
		GridData seperatorGridData = new GridData(SWT.FILL, SWT.TOP, true, false);
		seperatorGridData.horizontalSpan = 2;

		Label typeOfAnomalyLabel = new Label(container, SWT.NONE);
		typeOfAnomalyLabel.setText("Type:");

		Text typeOfAnomalyText = new Text(container, SWT.READ_ONLY | SWT.BORDER);

		// Need to set the font to bold of the labels
		FontDescriptor boldDescriptor = FontDescriptor.createFrom(typeOfAnomalyLabel.getFont()).setStyle(SWT.BOLD);
		Font boldFont = boldDescriptor.createFont(typeOfAnomalyLabel.getDisplay());
		typeOfAnomalyLabel.setFont(boldFont);

		Label seperatorTypeOfAnomaly = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		seperatorTypeOfAnomaly.setLayoutData(seperatorGridData);

		String typeOfAnomaly = "";
		String affectedElements = "";
		String dates = "";
		String typeOfEffectedElements = "";

		if (anomaly instanceof DwVoidFeatureModelAnomaly) {
			typeOfAnomaly = "Void Feature Model";
			typeOfEffectedElements = "Affected Context Values:";
			DwVoidFeatureModelAnomaly p = (DwVoidFeatureModelAnomaly) anomaly;

			EList<HyContextValue> contextValues = p.getContextValueModel().getValues();

			for (HyContextValue contextValue : contextValues) {

				affectedElements += contextValue.getContext().getName() + " = ";

				if (contextValue.getValue() instanceof HyNumberValue) {
					affectedElements += Integer.toString(((HyNumberValue) contextValue.getValue()).getValue()) + "\n";
				} else if (contextValue.getValue() instanceof HyStringValue) {
					affectedElements += ((HyStringValue) contextValue.getValue()).getValue() + "\n";
				} else if (contextValue.getValue() instanceof HyEnumValue) {
					affectedElements += ((HyEnumValue) contextValue.getValue()).getEnumLiteral().getName() + "\n";
				}

			}

		} else if (anomaly instanceof DwDeadFeatureAnomaly) {
			typeOfAnomaly = "Dead Feature";
			typeOfEffectedElements = "Affected Feature:";

			affectedElements += ((DwDeadFeatureAnomaly) anomaly).getFeature().getNames().get(0).getName();
		} else if (anomaly instanceof DwFalseOptionalFeatureAnomaly) {
			typeOfAnomaly = "False-Optional Feature";
			typeOfEffectedElements = "Affected Feature:";

			affectedElements += ((DwFalseOptionalFeatureAnomaly) anomaly).getFeature().getNames().get(0).getName();

		}

		typeOfAnomalyText.setText(typeOfAnomaly);

		seperatorGridData = new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1);

		Label affectedElementsLabel = new Label(container, SWT.NONE | SWT.BOLD);
		affectedElementsLabel.setText(typeOfEffectedElements);
		affectedElementsLabel.setFont(boldFont);

		Text affectedElementsText = new Text(container, SWT.READ_ONLY | SWT.BORDER | SWT.V_SCROLL);

		affectedElementsText.setText(affectedElements);
		// affectedElementsText.setLayoutData(data);

		Label labelSeperator2 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);

		labelSeperator2.setLayoutData(seperatorGridData);

		Label dateLabel = new Label(container, SWT.NONE);
		dateLabel.setText("Date:");
		dateLabel.setFont(boldFont);

		Text dateField = new Text(container, SWT.READ_ONLY | SWT.BORDER);

		if (anomaly.getValidSince() != null) {
			dates += anomaly.getValidSince().toString();

			if (anomaly.getValidUntil() != null) {
				dates += " - " + anomaly.getValidUntil().toString();
			} else {
				dates += " - eternity";
			}

		} else {

			dates += "NULL";

			if (anomaly.getValidSince() != null) {
				dates += " - " + anomaly.getValidUntil().toString();
			}
		}

		dateField.setText(dates);

		Label labelSeperator3 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);

		labelSeperator3.setLayoutData(seperatorGridData);

		GridData dataURI = new GridData();
		dataURI.grabExcessHorizontalSpace = true;
		dataURI.horizontalAlignment = GridData.FILL;

		Label explanationsLabel = new Label(container, SWT.NONE);
		explanationsLabel.setText("Explanations:");

		explanationsLabel.setFont(boldFont);

//		uriText = new Text(container, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
//		// uriText.setLayoutData(new GridData(GridData.FILL_BOTH));
//		seperatorGridData = new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1);
//		uriText.setLayoutData(seperatorGridData);
//		List<String> explanations = new ArrayList<String>();
//		for (AnomalyConstraintExplanation explanation : anomalyExplanation) {
//			if (explanations.size() > 0) {
//				explanations.add("-----");
//			}
//			explanations.add(explanation.explain());
//		}
//		String resultString = "";
//
//		for (String e : explanations) {
//			resultString += e + "\n";
//		}
//
//		uriText.setText(resultString);
		
		final Tree tree = new Tree(container, SWT.MULTI | SWT.BORDER| SWT.V_SCROLL | SWT.H_SCROLL);
		seperatorGridData = new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1);
		tree.setLayoutData(seperatorGridData);
		
		List<AnomalyConstraintExplanation> sortedExplanationList = new ArrayList<AnomalyConstraintExplanation>(anomalyExplanation.size());
		sortedExplanationList.addAll(anomalyExplanation);
		
		Collections.sort(sortedExplanationList, new Comparator<AnomalyConstraintExplanation>() {
			@Override
			public int compare(AnomalyConstraintExplanation obj, AnomalyConstraintExplanation other) {
				// sort Root > Everything > HyConstraint > HyValidityFormula
				
				if (obj.getAffectedObject() instanceof HyRootFeature) {
					return -1;
				}
				if (other.getAffectedObject() instanceof HyRootFeature) {
					return 1;
				}
				
				if (obj.getAffectedObject() instanceof HyConstraint) {
					if (other.getAffectedObject() instanceof HyValidityFormula) {
						return -1;
					}
					return 1;
				}
				if (other.getAffectedObject() instanceof HyConstraint) {
					if (obj.getAffectedObject() instanceof HyValidityFormula) {
						return 1;
					}
					return -1;
				}
				
				if (obj.getAffectedObject() instanceof HyValidityFormula) {
					return 1;
				}
				if (other.getAffectedObject() instanceof HyValidityFormula) {
					return -1;
				}
				return 0;
			}			
		});
		
		for (AnomalyConstraintExplanation explanation : sortedExplanationList) {
			// special case: dead parent is the reason.
			if (explanation.getAffectedObject() == null) {
				TreeItem itemRoot = new TreeItem(tree, 0);
				itemRoot.setText(explanation.getTranslatedConstraint());
				break;
			}
			
			TreeItem itemRoot = new TreeItem(tree, 0);
			itemRoot.setText(explanation.explainConstraintString());
			
			TreeItem translatedConstraintText = new TreeItem(itemRoot, 0);
			translatedConstraintText.setText("Translated Constraint");
			TreeItem translatedConstraint = new TreeItem(translatedConstraintText, 0);
			translatedConstraint.setText(explanation.getTranslatedConstraint());
			
			List<String> causingStrings = explanation.explainCausingOperations();
			if (causingStrings.size() > 0) {
				TreeItem causingOps = new TreeItem(itemRoot, 0);
				causingOps.setText("Causing Evolution Operations");
				for (String opString : causingStrings) {
					TreeItem causingOpsItem = new TreeItem(causingOps, 0);
					causingOpsItem.setText(opString);
				}
			}
			
			List<String> involvedStrings = explanation.explainInvolvedPastEvolutionOperations();
			if (involvedStrings.size() > 0) {
				TreeItem involvedOps = new TreeItem(itemRoot, 0);
				involvedOps.setText("Involved Past Evolution Operations");
				for (String opString : involvedStrings) {
					TreeItem involvedOpsItem = new TreeItem(involvedOps, 0);
					involvedOpsItem.setText(opString);
				}
			}
		}
		
		expandAll(tree.getItems(), true);

		return container;
	}
	
	private void expandAll(TreeItem[] items, boolean expand) {
		for (TreeItem item : items) {
			item.setExpanded(expand);
			expandAll(item.getItems(), expand);
		}
	}

	private void createAnomalyInformationControlParts(Composite container) {

	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, "OK", true);

	}

	@Override
	protected Point getInitialSize() {
		return new Point(600, 420);
//		return new Point(480, 420);
	}
}
