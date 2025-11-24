package com.example.college.rest.internal.graphql.servlet.v1_0;

import com.example.college.rest.internal.graphql.mutation.v1_0.Mutation;
import com.example.college.rest.internal.graphql.query.v1_0.Query;
import com.example.college.rest.internal.resource.v1_0.StudentResourceImpl;
import com.example.college.rest.resource.v1_0.StudentResource;

import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author kushp
 * @generated
 */
@Component(service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setStudentResourceComponentServiceObjects(
			_studentResourceComponentServiceObjects);

		Query.setStudentResourceComponentServiceObjects(
			_studentResourceComponentServiceObjects);
	}

	public String getApplicationName() {
		return "CollegeRest";
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/college-rest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	public ObjectValuePair<Class<?>, String> getResourceMethodObjectValuePair(
		String methodName, boolean mutation) {

		if (mutation) {
			return _resourceMethodObjectValuePairs.get(
				"mutation#" + methodName);
		}

		return _resourceMethodObjectValuePairs.get("query#" + methodName);
	}

	private static final Map<String, ObjectValuePair<Class<?>, String>>
		_resourceMethodObjectValuePairs =
			new HashMap<String, ObjectValuePair<Class<?>, String>>() {
				{
					put(
						"mutation#createStudent",
						new ObjectValuePair<>(
							StudentResourceImpl.class, "postStudent"));
					put(
						"mutation#createStudentBatch",
						new ObjectValuePair<>(
							StudentResourceImpl.class, "postStudentBatch"));
					put(
						"mutation#deleteStudent",
						new ObjectValuePair<>(
							StudentResourceImpl.class, "deleteStudent"));
					put(
						"mutation#deleteStudentBatch",
						new ObjectValuePair<>(
							StudentResourceImpl.class, "deleteStudentBatch"));
					put(
						"mutation#updateStudent",
						new ObjectValuePair<>(
							StudentResourceImpl.class, "putStudent"));
					put(
						"mutation#updateStudentBatch",
						new ObjectValuePair<>(
							StudentResourceImpl.class, "putStudentBatch"));

					put(
						"query#students",
						new ObjectValuePair<>(
							StudentResourceImpl.class, "getStudents"));
					put(
						"query#student",
						new ObjectValuePair<>(
							StudentResourceImpl.class, "getStudent"));
				}
			};

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<StudentResource>
		_studentResourceComponentServiceObjects;

}