document.addEventListener('DOMContentLoaded', function () {
  setupColorRadios();
  setupSizeRadios();
  setupQuantityControls();
});

function setupColorRadios() {
  // 'color__radio' 이름을 가진 모든 라디오 버튼에 대해 반복
  const colorRadios = document.getElementsByName('color__radio');
  colorRadios.forEach(function (radio) {
    radio.addEventListener('click', function () {
      this.checked = true;
    });
  });
}

function setupSizeRadios() {
  // 'size__radio' 이름을 가진 모든 라디오 버튼에 대해 반복
  const sizeRadios = document.getElementsByName('size__radio');
  sizeRadios.forEach(function (radio) {
    radio.addEventListener('click', function () {
      this.checked = true;

      sizeRadios.forEach(radio => radio.parentNode.classList.remove('active'));
      this.parentNode.classList.add('active');
    });
  });
}

/*
* 수량 +, -
* */
function setupQuantityControls() {
  // 수량 감소 버튼
  const decreaseButton = document.getElementById('decrement');
  // 수량 증가 버튼
  const increaseButton = document.getElementById('increment');
  // 수량 입력 필드
  const quantityInput = document.getElementById('quantity');

  decreaseButton.addEventListener('click', function () {
    updateQuantity(-1);
  });

  increaseButton.addEventListener('click', function () {
    updateQuantity(1);
  });

  function updateQuantity(change) {
    const currentValue = parseInt(quantityInput.value, 10) || 0;
    const newValue = currentValue + change;
    quantityInput.value = newValue > 1 ? newValue : 1;
  }
}