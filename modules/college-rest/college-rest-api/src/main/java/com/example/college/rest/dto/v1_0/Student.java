package com.example.college.rest.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author kushp
 * @generated
 */
@Generated("")
@GraphQLName("Student")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Student")
public class Student implements Serializable {

	public static Student toDTO(String json) {
		return ObjectMapperUtil.readValue(Student.class, json);
	}

	public static Student unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(Student.class, json);
	}

	@Schema
	public String getBranch() {
		if (_branchSupplier != null) {
			branch = _branchSupplier.get();

			_branchSupplier = null;
		}

		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;

		_branchSupplier = null;
	}

	@JsonIgnore
	public void setBranch(
		UnsafeSupplier<String, Exception> branchUnsafeSupplier) {

		_branchSupplier = () -> {
			try {
				return branchUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String branch;

	@JsonIgnore
	private Supplier<String> _branchSupplier;

	@Schema
	public String getName() {
		if (_nameSupplier != null) {
			name = _nameSupplier.get();

			_nameSupplier = null;
		}

		return name;
	}

	public void setName(String name) {
		this.name = name;

		_nameSupplier = null;
	}

	@JsonIgnore
	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		_nameSupplier = () -> {
			try {
				return nameUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String name;

	@JsonIgnore
	private Supplier<String> _nameSupplier;

	@Schema
	public Long getStudentId() {
		if (_studentIdSupplier != null) {
			studentId = _studentIdSupplier.get();

			_studentIdSupplier = null;
		}

		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;

		_studentIdSupplier = null;
	}

	@JsonIgnore
	public void setStudentId(
		UnsafeSupplier<Long, Exception> studentIdUnsafeSupplier) {

		_studentIdSupplier = () -> {
			try {
				return studentIdUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long studentId;

	@JsonIgnore
	private Supplier<Long> _studentIdSupplier;

	@Schema
	public Integer getYear() {
		if (_yearSupplier != null) {
			year = _yearSupplier.get();

			_yearSupplier = null;
		}

		return year;
	}

	public void setYear(Integer year) {
		this.year = year;

		_yearSupplier = null;
	}

	@JsonIgnore
	public void setYear(UnsafeSupplier<Integer, Exception> yearUnsafeSupplier) {
		_yearSupplier = () -> {
			try {
				return yearUnsafeSupplier.get();
			}
			catch (RuntimeException runtimeException) {
				throw runtimeException;
			}
			catch (Exception exception) {
				throw new RuntimeException(exception);
			}
		};
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer year;

	@JsonIgnore
	private Supplier<Integer> _yearSupplier;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Student)) {
			return false;
		}

		Student student = (Student)object;

		return Objects.equals(toString(), student.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		String branch = getBranch();

		if (branch != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"branch\": ");

			sb.append("\"");

			sb.append(_escape(branch));

			sb.append("\"");
		}

		String name = getName();

		if (name != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(name));

			sb.append("\"");
		}

		Long studentId = getStudentId();

		if (studentId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"studentId\": ");

			sb.append(studentId);
		}

		Integer year = getYear();

		if (year != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"year\": ");

			sb.append(year);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "com.example.college.rest.dto.v1_0.Student",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof Map) {
						sb.append(_toJSON((Map<String, ?>)valueArray[i]));
					}
					else if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

	private Map<String, Serializable> _extendedProperties;

}