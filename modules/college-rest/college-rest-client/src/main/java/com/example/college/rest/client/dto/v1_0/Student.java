package com.example.college.rest.client.dto.v1_0;

import com.example.college.rest.client.function.UnsafeSupplier;
import com.example.college.rest.client.serdes.v1_0.StudentSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author kushp
 * @generated
 */
@Generated("")
public class Student implements Cloneable, Serializable {

	public static Student toDTO(String json) {
		return StudentSerDes.toDTO(json);
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public void setBranch(
		UnsafeSupplier<String, Exception> branchUnsafeSupplier) {

		try {
			branch = branchUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String branch;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public void setStudentId(
		UnsafeSupplier<Long, Exception> studentIdUnsafeSupplier) {

		try {
			studentId = studentIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long studentId;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setYear(UnsafeSupplier<Integer, Exception> yearUnsafeSupplier) {
		try {
			year = yearUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer year;

	@Override
	public Student clone() throws CloneNotSupportedException {
		return (Student)super.clone();
	}

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
		return StudentSerDes.toJSON(this);
	}

}