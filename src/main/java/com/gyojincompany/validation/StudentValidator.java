package com.gyojincompany.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gyojincompany.validation.dto.StudentDto;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {//검증할 객체(studentDto)의 클래스 타입 정보
		// TODO Auto-generated method stub
		return StudentDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		StudentDto studentDto = (StudentDto) target;
		//검증할 객체를 타겟으로 지정(Object 형 이므로 형변환 필요)
		
		String studentId = studentDto.getId();
//		System.out.println(studentId);
		String studentPw = studentDto.getPw();
//		System.out.println(studentPw);
		
		
//		if(studentId == null || studentId.trim().isEmpty()) {
//			errors.rejectValue("id", "trouble");
//		} else if(studentPw == null || studentPw.trim().isEmpty()) {
//			errors.rejectValue("pw", "trouble");
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "trouble");
		
		if(studentPw == null || studentPw.trim().isEmpty()) {
			errors.rejectValue("pw", "trouble");
		}
	}

}
