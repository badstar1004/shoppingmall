/*
* 이벤트 리스너 추가
* */
document.addEventListener("DOMContentLoaded", function() {
  addValidationListener("email", validateEmail);
  addValidationListener("password", validatePassword);
  addValidationListener("name", validateName);
  addValidationListener("phoneNumber", validatePhoneNumber);
});

function addValidationListener(inputId, validator) {
  const input = document.getElementById(inputId);
  const errorId = `${inputId}Error`;
  const error = document.getElementById(errorId);

  input.addEventListener("blur", function () {
    validator(input, error);
  });
}

/*
* 이메일 검증 및 중복확인
* */
function validateEmail(input, error) {
  const inputValue = input.value;
  if (!inputValue) {
    error.textContent = "이메일을 입력하세요.";
    return;
  }

  const mailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{3}$/i;
  if(!mailPattern.test(inputValue)) {
    error.textContent = "이메일 형식이 아닙니다.";
    return;
  }

  $.ajax({
    url: "/consumer/sign/check-email",
    type: "POST",
    contentType: "application/json; charset=utf-8",
    data: JSON.stringify({ email: inputValue }),
    success: function (response) {
      error.textContent = "사용 가능한 이메일입니다.";
    },
    error: function (xhr) {
      if(xhr.status === 409) {
        error.textContent = "이미 등록된 이메일입니다.";
      } else {
        error.textContent = JSON.parse(xhr.responseText).email;
      }
    }
  });
}

/*
* 비밀번호 검증
* */
function validatePassword(input, error) {
  const inputValue = input.value;
  if (!inputValue) {
    error.textContent = "비밀번호를 입력하세요";
    return;
  }

  const passwordPattern = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#]).{10,}$/;
  if (!passwordPattern.test(inputValue)) {
    error.textContent = "비밀번호는 영문, 숫자, 특수 문자(!, @, #)를 포함하여 10자리 이상이어야 합니다";
  } else {
    error.textContent = "";
  }
}

/*
* 이름 검증
* */
function validateName(input, error) {
  if (!input.value) {
    error.textContent = "이름을 입력하세요.";
  } else {
    error.textContent = "";
  }
}

/*
* 핸드폰번호 검증
* */
function validatePhoneNumber(input, error) {
  const inputValue = input.value;
  const phonePattern = /^\d{11}$/;

  if (inputValue) {
    if (!phonePattern.test(inputValue)) {
      error.textContent = "전화번호는 0~9까지의 숫자로 이루어진 11자리를 입력해야 합니다.";
    } else {
      error.textContent = "";
    }
  }
}