package com.kurento.kms.idl.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ComplexType extends Type {

	public enum TypeFormat {
		REGISTER, ENUM
	};

	@SerializedName("extends")
	private TypeRef extendsProp;

	private TypeFormat typeFormat;
	private List<Property> properties;
	private List<String> values;

	public ComplexType(String name, Doc doc, List<Property> properties,
			List<String> values) {
		super(name, doc);
		this.properties = properties;
		this.values = values;
		if (properties != null) {
			typeFormat = TypeFormat.REGISTER;
		} else if (values != null) {
			typeFormat = TypeFormat.ENUM;
		} else {
			new AssertionError(
					"Properties or values have to have a non null value");
		}
	}

	public TypeRef getExtends() {
		return extendsProp;
	}

	public void setExtends(TypeRef extendsProp) {
		this.extendsProp = extendsProp;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public TypeFormat getTypeFormat() {
		return typeFormat;
	}

	public List<String> getValues() {
		return values;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public void setValues(List<String> values) {
		this.values = values;
	}

	@Override
	public List<ModelElement> getChildren() {
		List<ModelElement> children = new ArrayList<ModelElement>();
		if (extendsProp != null) {
			children.add(extendsProp);
		}

		if (properties != null) {
			children.addAll(properties);
		}
		return children;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((extendsProp == null) ? 0 : extendsProp.hashCode());
		result = prime * result
				+ ((properties == null) ? 0 : properties.hashCode());
		result = prime * result
				+ ((typeFormat == null) ? 0 : typeFormat.hashCode());
		result = prime * result + ((values == null) ? 0 : values.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComplexType other = (ComplexType) obj;
		if (extendsProp == null) {
			if (other.extendsProp != null)
				return false;
		} else if (!extendsProp.equals(other.extendsProp))
			return false;
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
			return false;
		if (typeFormat != other.typeFormat)
			return false;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		return true;
	}

}
