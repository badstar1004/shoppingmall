/*
* 이벤트 리스너 추가
* */
document.addEventListener("DOMContentLoaded", function() {
  addValidationListener("email", validateEmail);
  addValidationListener("password", validatePassword);
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
  } else {
    error.textContent = "";
  }

  const mailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{3}$/i;
  if(!mailPattern.test(inputValue)) {
    error.textContent = "이메일 형식이 아닙니다.";
  } else {
    error.textContent = "";
  }
}

/*
* 비밀번호 검증
* */
function validatePassword(input, error) {
  const inputValue = input.value;
  if (!inputValue) {
    error.textContent = "비밀번호를 입력하세요";
    return;
  } else {
    error.textContent = "";
  }

  const passwordPattern = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#]).{10,}$/;
  if (!passwordPattern.test(inputValue)) {
    error.textContent = "비밀번호는 영문, 숫자, 특수 문자(!, @, #)를 포함하여 10자리 이상이어야 합니다";
  } else {
    error.textContent = "";
  }
}