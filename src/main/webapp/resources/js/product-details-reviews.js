$(document).ready(function () {
  // 상품 ID
  const productId = $("#productId").val();
  loadReviews(productId, 1, 20); // 페이지 로드 시 리뷰 로딩 실행

});


function loadReviews(productId, page, size) {
  console.log(productId, page, size);
  $.ajax({
    url: `/reviews/${productId}?page=${page}&size=${size}`,
    type: "GET",
    dataType: "json",
    success: function (response) {

      let reviewsHtml = '';

      if (response.length === 0) {
        reviewsHtml += `<div>리뷰가 없습니다.</div>`;

      } else {
        response.withConsumerDtoList.forEach(function (result) {
          let starsHtml = '';
          for (let i = 1; i <= 5; i++) {
            if (i <= result.rating) {
              starsHtml += `<i class="fa fa-star"></i>`; // 전체 별
            } else if (i - result.rating < 1) {
              starsHtml += `<i class="fa fa-star-half-o"></i>`; // 반 별 (선택적, 필요에 따라 사용)
            } else {
              starsHtml += `<i class="fa fa-star-o"></i>`; // 빈 별
            }
          }

          reviewsHtml += `
                    <div class="review">
                      <div class="review-header">
                        <h5 class="consumer-name">` + result.consumerName + `</h5>
                        <div class="rating">` + starsHtml + `</div>
                        <div class="review-date">` + result.createdAt + `</div>
                      </div>
                      <div class="review-options">
                        <span class="option-size">사이즈: ` + result.optionSize + `</span>
                        <span class="option-color">색상: ` + result.optionColor + `</span>
                      </div>
                      <p class="review-text">` + result.reviewText + `</p>
                    </div>`;
        });
      }

      // 생성된 문자열 페이지 해당 요소에 삽입
      $('#tabs-2').html(reviewsHtml);

      // 페이징 핸들러 생성
      let pagingHtml = `<div class="pagination">`;
      if (response.pagingHandle.showPrev) {
        pagingHtml += `<a class="paging" href="#" data-page="${response.pagingHandle.page - 1}">&laquo;</a>`;
      }

      for (let i = response.pagingHandle.beginPage; i <= response.pagingHandle.endPage; i++) {
        if (i === response.pagingHandle.page) {
          pagingHtml += `<span><strong>`+ i +`</strong></span>`;
        } else {
          pagingHtml += `<a class="paging" href="#" data-page="`+ i +`">`+ i +`</a>`;
        }
      }

      if (response.pagingHandle.showNext) {
        pagingHtml += `<a class="paging" href="#" data-page="`+ response.pagingHandle.page + 1 +`">&rsaquo;</a>`;
      }
      pagingHtml += `</div>`;

      // 페이징 문자열을 페이지 해당 요소에 삽입
      $('#tabs-2').append(pagingHtml);

      // AJAX 호출 성공 후 페이지네이션 링크에 대한 클릭 이벤트 리스너 설정
      $('#tabs-2').on('click', '.paging', function (e) {
        e.preventDefault(); // 기본 이벤트를 방지합니다.
        const page = $(this).data('page'); // data-page 속성에서 페이지 번호를 가져옵니다.
        loadReviews(productId, page, 20); // 가져온 페이지 번호로 리뷰를 로드합니다.
      });
    },

    error: function (error) {
      console.error('Error fetching reviews:', error);
    }
  });
}