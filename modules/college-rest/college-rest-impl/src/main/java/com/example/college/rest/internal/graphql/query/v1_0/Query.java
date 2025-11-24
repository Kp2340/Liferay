package com.example.college.rest.internal.graphql.query.v1_0;

import com.example.college.rest.dto.v1_0.Student;
import com.example.college.rest.resource.v1_0.StudentResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author kushp
 * @generated
 */
@Generated("")
public class Query {

	public static void setStudentResourceComponentServiceObjects(
		ComponentServiceObjects<StudentResource>
			studentResourceComponentServiceObjects) {

		_studentResourceComponentServiceObjects =
			studentResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {students(page: ___, pageSize: ___){}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Object students(
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page)
		throws Exception {

		return _applyComponentServiceObjects(
			_studentResourceComponentServiceObjects,
			this::_populateResourceContext,
			studentResource -> studentResource.getStudents(
				Pagination.of(page, pageSize)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {student(studentId: ___){studentId, name, branch, year}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Student student(@GraphQLName("studentId") Long studentId)
		throws Exception {

		return _applyComponentServiceObjects(
			_studentResourceComponentServiceObjects,
			this::_populateResourceContext,
			studentResource -> studentResource.getStudent(studentId));
	}

	@GraphQLName("StudentPage")
	public class StudentPage {

		public StudentPage(Page studentPage) {
			actions = studentPage.getActions();

			items = studentPage.getItems();
			lastPage = studentPage.getLastPage();
			page = studentPage.getPage();
			pageSize = studentPage.getPageSize();
			totalCount = studentPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map<String, String>> actions;

		@GraphQLField
		protected java.util.Collection<Student> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(StudentResource studentResource)
		throws Exception {

		studentResource.setContextAcceptLanguage(_acceptLanguage);
		studentResource.setContextCompany(_company);
		studentResource.setContextHttpServletRequest(_httpServletRequest);
		studentResource.setContextHttpServletResponse(_httpServletResponse);
		studentResource.setContextUriInfo(_uriInfo);
		studentResource.setContextUser(_user);
		studentResource.setGroupLocalService(_groupLocalService);
		studentResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<StudentResource>
		_studentResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}