/**
 */
package eu.hyvar.feature.provider;


import eu.hyvar.evolution.HyEvolutionFactory;
import eu.hyvar.evolution.HyEvolutionPackage;

import eu.hyvar.feature.HyFeature;
import eu.hyvar.feature.HyFeatureFactory;
import eu.hyvar.feature.HyFeaturePackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link eu.hyvar.feature.HyFeature} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class HyFeatureItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HyFeatureItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addValidSincePropertyDescriptor(object);
			addValidUntilPropertyDescriptor(object);
			addIdPropertyDescriptor(object);
			addGroupMembershipPropertyDescriptor(object);
			addDeprecatedSincePropertyDescriptor(object);
			addTypesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Valid Since feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValidSincePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HyTemporalElement_validSince_feature"),
				 getString("_UI_HyTemporalElement_validSince_description"),
				 HyEvolutionPackage.Literals.HY_TEMPORAL_ELEMENT__VALID_SINCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Valid Until feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValidUntilPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HyTemporalElement_validUntil_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HyTemporalElement_validUntil_feature", "_UI_HyTemporalElement_type"),
				 HyEvolutionPackage.Literals.HY_TEMPORAL_ELEMENT__VALID_UNTIL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HyTemporalElement_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HyTemporalElement_id_feature", "_UI_HyTemporalElement_type"),
				 HyEvolutionPackage.Literals.HY_TEMPORAL_ELEMENT__ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Group Membership feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGroupMembershipPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HyFeature_groupMembership_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HyFeature_groupMembership_feature", "_UI_HyFeature_type"),
				 HyFeaturePackage.Literals.HY_FEATURE__GROUP_MEMBERSHIP,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Deprecated Since feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDeprecatedSincePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HyFeature_deprecatedSince_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HyFeature_deprecatedSince_feature", "_UI_HyFeature_type"),
				 HyFeaturePackage.Literals.HY_FEATURE__DEPRECATED_SINCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Types feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HyFeature_types_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HyFeature_types_feature", "_UI_HyFeature_type"),
				 HyFeaturePackage.Literals.HY_FEATURE__TYPES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(HyEvolutionPackage.Literals.HY_NAMED_ELEMENT__NAMES);
			childrenFeatures.add(HyFeaturePackage.Literals.HY_FEATURE__VERSIONS);
			childrenFeatures.add(HyFeaturePackage.Literals.HY_FEATURE__PARENT_OF);
			childrenFeatures.add(HyFeaturePackage.Literals.HY_FEATURE__ATTRIBUTES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns HyFeature.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/HyFeature"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((HyFeature)object).getId();
		return label == null || label.length() == 0 ?
			getString("_UI_HyFeature_type") :
			getString("_UI_HyFeature_type") + " " + label;
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(HyFeature.class)) {
			case HyFeaturePackage.HY_FEATURE__VALID_SINCE:
			case HyFeaturePackage.HY_FEATURE__VALID_UNTIL:
			case HyFeaturePackage.HY_FEATURE__ID:
			case HyFeaturePackage.HY_FEATURE__DEPRECATED_SINCE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case HyFeaturePackage.HY_FEATURE__NAMES:
			case HyFeaturePackage.HY_FEATURE__VERSIONS:
			case HyFeaturePackage.HY_FEATURE__PARENT_OF:
			case HyFeaturePackage.HY_FEATURE__ATTRIBUTES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(HyEvolutionPackage.Literals.HY_NAMED_ELEMENT__NAMES,
				 HyEvolutionFactory.eINSTANCE.createHyName()));

		newChildDescriptors.add
			(createChildParameter
				(HyFeaturePackage.Literals.HY_FEATURE__VERSIONS,
				 HyFeatureFactory.eINSTANCE.createHyVersion()));

		newChildDescriptors.add
			(createChildParameter
				(HyFeaturePackage.Literals.HY_FEATURE__PARENT_OF,
				 HyFeatureFactory.eINSTANCE.createHyFeatureChild()));

		newChildDescriptors.add
			(createChildParameter
				(HyFeaturePackage.Literals.HY_FEATURE__ATTRIBUTES,
				 HyFeatureFactory.eINSTANCE.createHyNumberAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(HyFeaturePackage.Literals.HY_FEATURE__ATTRIBUTES,
				 HyFeatureFactory.eINSTANCE.createHyBooleanAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(HyFeaturePackage.Literals.HY_FEATURE__ATTRIBUTES,
				 HyFeatureFactory.eINSTANCE.createHyStringAttribute()));

		newChildDescriptors.add
			(createChildParameter
				(HyFeaturePackage.Literals.HY_FEATURE__ATTRIBUTES,
				 HyFeatureFactory.eINSTANCE.createHyEnumAttribute()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return FeatureEditPlugin.INSTANCE;
	}

}
