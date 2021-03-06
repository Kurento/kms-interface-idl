package com.kurento.kms.idl.model;

import com.google.gson.JsonElement;

public class Param extends DataItem {

	public Param(String name, Doc doc, TypeRef type, boolean optional) {
		super(name, doc, type, optional);
	}

	public Param(String name, Doc doc, TypeRef type, JsonElement defaultValue) {
		super(name, doc, type, defaultValue);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Param [type()=");
		sb.append(getType());
		sb.append(", required()=");
		sb.append(isOptional());
		sb.append(", doc()=");
		sb.append(getDoc());
		if (isOptional()) {
			sb.append(", defaultValue()=");
			sb.append(getDefaultValue());
		}
		sb.append("]");

		return sb.toString();
	}
}
