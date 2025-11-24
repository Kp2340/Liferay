/**
SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
**/

/**
package com.example.college.service.impl;
import com.example.college.service.base.StudentLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import org.osgi.service.component.annotations.Component;
@author Brian Wing Shun Chan
@Component(
	property = "model.class.name=com.example.college.model.Student",
	service = AopService.class
)
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {
}
**/

package com.example.college.service.impl;
import com.example.college.model.Student;
import com.example.college.service.StudentLocalService;
import com.example.college.service.base.StudentLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import java.util.Date;
import java.util.List;
import org.osgi.service.component.annotations.Component;
/**
 * @author kushp
 */
@Component(property = "model.class.name=com.example.college.model.Student", service = { AopService.class,
		StudentLocalService.class })
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {
	public List<Student> getAllStudents() {
		try {
			return com.liferay.portal.kernel.transaction.TransactionInvokerUtil.invoke(
					transactionConfig,
					() -> studentPersistence.findAll());
		} catch (Throwable throwable) {
			throw new RuntimeException(throwable);
		}
	}
	private static final com.liferay.portal.kernel.transaction.TransactionConfig transactionConfig;
	static {
		transactionConfig = com.liferay.portal.kernel.transaction.TransactionConfig.Factory.create(
				com.liferay.portal.kernel.transaction.Propagation.SUPPORTS,
				new Class<?>[] { Exception.class });
	}
	public Student addStudent(String name, String branch, int year) {
		long studentId = counterLocalService.increment(Student.class.getName());
		Student student = createStudent(studentId);
		student.setName(name);
		student.setBranch(branch);
		student.setYear(year);
		student.setCreateDate(new Date());
		student.setModifiedDate(new Date());
		return addStudent(student);
	}
	public Student updateStudent(long studentId, String name, String branch, int year) throws PortalException {
		Student student = getStudent(studentId);
		student.setName(name);
		student.setBranch(branch);
		student.setYear(year);
		student.setModifiedDate(new Date());
		return updateStudent(student);
	}
}