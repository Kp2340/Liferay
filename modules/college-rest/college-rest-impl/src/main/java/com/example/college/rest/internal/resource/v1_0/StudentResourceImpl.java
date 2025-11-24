package com.example.college.rest.internal.resource.v1_0;

import com.example.college.service.StudentLocalService;
import com.example.college.rest.dto.v1_0.Student;
import com.example.college.rest.resource.v1_0.StudentResource;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author kushp
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/student.properties", scope = ServiceScope.PROTOTYPE, service = StudentResource.class)
public class StudentResourceImpl extends BaseStudentResourceImpl {

	@Override
	public Response deleteStudent(Long studentId) throws Exception {
		_studentLocalService.deleteStudent(studentId);
		return Response.ok().build();
	}

	@Override
	public Student getStudent(Long studentId) throws Exception {
		com.example.college.model.Student model = _studentLocalService.getStudent(studentId);
		return _toDTO(model);
	}

	@Override
	public Object getStudents(Pagination pagination) throws Exception {
		List<com.example.college.model.Student> models = _studentLocalService.getAllStudents();

		List<Student> dtos = models.stream()
				.map(this::_toDTO)
				.collect(Collectors.toList());

		// Return the page object with totalCount
		return Page.of(dtos, pagination, (long) models.size());
	}

	@Override
	public Student postStudent(Student student) throws Exception {
		long studentId = CounterLocalServiceUtil.increment(com.example.college.model.Student.class.getName());

		com.example.college.model.Student model = _studentLocalService.createStudent(studentId);
		model.setName(student.getName());
		model.setBranch(student.getBranch());
		model.setYear(student.getYear());

		// Set audit fields if necessary, e.g.
		// model.setCreateDate(new java.util.Date());

		_studentLocalService.addStudent(model);

		return _toDTO(model);
	}

	@Override
	public Student putStudent(Long studentId, Student student) throws Exception {
		com.example.college.model.Student model = _studentLocalService.getStudent(studentId);

		model.setName(student.getName());
		model.setBranch(student.getBranch());
		model.setYear(student.getYear());

		_studentLocalService.updateStudent(model);

		return _toDTO(model);
	}

	private Student _toDTO(com.example.college.model.Student model) {
		Student dto = new Student();
		dto.setStudentId(model.getStudentId());
		dto.setName(model.getName());
		dto.setBranch(model.getBranch());
		dto.setYear(model.getYear());
		return dto;
	}

	@Reference
	private StudentLocalService _studentLocalService;
}