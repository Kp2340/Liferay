package com.example.college.rest.client.serdes.v1_0;

import com.example.college.rest.client.dto.v1_0.Student;
import com.example.college.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author kushp
 * @generated
 */
@Generated("")
public class StudentSerDes {

	public static Student toDTO(String json) {
		StudentJSONParser studentJSONParser = new StudentJSONParser();

		return studentJSONParser.parseToDTO(json);
	}

	public static Student[] toDTOs(String json) {
		StudentJSONParser studentJSONParser = new StudentJSONParser();

		return studentJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Student student) {
		if (student == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (student.getBranch() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"branch\": ");

			sb.append("\"");

			sb.append(_escape(student.getBranch()));

			sb.append("\"");
		}

		if (student.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(student.getName()));

			sb.append("\"");
		}

		if (student.getStudentId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"studentId\": ");

			sb.append(student.getStudentId());
		}

		if (student.getYear() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"year\": ");

			sb.append(student.getYear());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		StudentJSONParser studentJSONParser = new StudentJSONParser();

		return studentJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Student student) {
		if (student == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (student.getBranch() == null) {
			map.put("branch", null);
		}
		else {
			map.put("branch", String.valueOf(student.getBranch()));
		}

		if (student.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(student.getName()));
		}

		if (student.getStudentId() == null) {
			map.put("studentId", null);
		}
		else {
			map.put("studentId", String.valueOf(student.getStudentId()));
		}

		if (student.getYear() == null) {
			map.put("year", null);
		}
		else {
			map.put("year", String.valueOf(student.getYear()));
		}

		return map;
	}

	public static class StudentJSONParser extends BaseJSONParser<Student> {

		@Override
		protected Student createDTO() {
			return new Student();
		}

		@Override
		protected Student[] createDTOArray(int size) {
			return new Student[size];
		}

		@Override
		protected boolean parseMaps(String jsonParserFieldName) {
			if (Objects.equals(jsonParserFieldName, "branch")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "studentId")) {
				return false;
			}
			else if (Objects.equals(jsonParserFieldName, "year")) {
				return false;
			}

			return false;
		}

		@Override
		protected void setField(
			Student student, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "branch")) {
				if (jsonParserFieldValue != null) {
					student.setBranch((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					student.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "studentId")) {
				if (jsonParserFieldValue != null) {
					student.setStudentId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "year")) {
				if (jsonParserFieldValue != null) {
					student.setYear(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
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
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			sb.append(_toJSON(value));

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static String _toJSON(Object value) {
		if (value instanceof Map) {
			return _toJSON((Map)value);
		}

		Class<?> clazz = value.getClass();

		if (clazz.isArray()) {
			StringBuilder sb = new StringBuilder("[");

			Object[] values = (Object[])value;

			for (int i = 0; i < values.length; i++) {
				sb.append(_toJSON(values[i]));

				if ((i + 1) < values.length) {
					sb.append(", ");
				}
			}

			sb.append("]");

			return sb.toString();
		}

		if (value instanceof String) {
			return "\"" + _escape(value) + "\"";
		}

		return String.valueOf(value);
	}

}