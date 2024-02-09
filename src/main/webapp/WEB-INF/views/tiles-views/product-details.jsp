<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__left product__thumb nice-scroll" tabindex="1" style="overflow-y: hidden; outline: none;">
                            <c:forEach items="${productDetails.productImageList}" var="productImage">
                                <a class="pt active" href="<c:out value="${productImage.imageUrl}"/> ">
                                    <img src="<c:out value="${productImage.imageUrl}"/> " alt="">
                                </a>
                            </c:forEach>
                        </div>
                        <div class="product__details__slider__content">
                            <div class="product__details__pic__slider owl-carousel owl-loaded">
                                <div class="owl-stage-outer">
                                    <div class="owl-stage" style="transform: translate3d(0px, 0px, 0px); transition: all 3.6s ease 0s; width: 1652px;">
                                        <c:forEach items="${productDetails.productImageList}" var="image" varStatus="status">
                                            <div class="owl-item" style="width: 412.891px;">
                                                <img data-hash="product-${status.index + 1}" class="product__big__img" src="${image.imageUrl}" alt="">
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                                <div class="owl-nav">
                                    <button type="button" role="presentation" class="owl-prev disabled">
                                        <i class="arrow_carrot-left"></i>
                                    </button>
                                    <button type="button" role="presentation" class="owl-next">
                                        <i class="arrow_carrot-right"></i>
                                    </button>
                                </div>
                                <div class="owl-dots disabled"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="product__details__text">
                        <h3><c:out value="${productDetails.product.productName}"/> </h3>
                        <div class="rating">
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <i class="fa fa-star"></i>
                            <span>( <c:out value="${productDetails.reviewCount}"/> reviews )</span>
                        </div>
                        <div class="product__details__price"><c:out value="${productDetails.product.price} 원"/> </div>
                        <div class="product__details__button">
                            <div class="quantity">
                                <span>Quantity:</span>
                                <div class="pro-qty">
                                    <span class="dec qtybtn">-</span>
                                    <input type="text" value="1">
                                    <span class="inc qtybtn">+</span></div>
                            </div>
                            <a href="#" class="cart-btn"><span class="icon_bag_alt"></span> 장바구니 추가 </a>
                            <ul>
                                <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                                <li><a href="#"><span class="icon_adjust-horiz"></span></a></li>
                            </ul>
                        </div>
                        <div class="product__details__widget">
                            <ul>
                                <li>
                                    <span>size:</span>
                                    <div class="size__btn">
                                        <c:forEach items="${productDetails.optionSizeDtoList}" var="size">
                                            <label for="${size.optionSize}-btn" class="">
                                                <input type="radio" name="size__radio" id="${size.optionSize}-btn">
                                                <c:out value="${size.optionSize}"/>
                                            </label>
                                        </c:forEach>
                                    </div>
                                </li>
                                <li>
                                    <span>color:</span>
                                    <div class="color__checkbox">
                                        <c:forEach items="${productDetails.optionColorDtoList}" var="color">
                                            <label for="<c:out value="${color.optionColor}"/>" >
                                                <input type="radio" name="color__radio" id="<c:out value="${color.optionColor}"/>" >
                                                <span class="checkmark" style="background-color: <c:out value="${color.rgbValue}" />"></span>
                                            </label>
                                        </c:forEach>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab" aria-selected="true">상품 상세</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab" aria-selected="false">리뷰 ( <c:out value="${productDetails.reviewCount}"/> )</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <h6>상품 상세 설명</h6>
                                <c:forEach items="${productDetails.productDescriptionList}" var="details">
                                    <c:if test="${details.contentsType == 'TEXT'}">
                                        <p>${details.contentsValue}</p>
                                    </c:if>
                                    <c:if test="${details.contentsType == 'IMAGE'}">
                                        <img src="${details.contentsValue}" alt=""/>
                                    </c:if>
                                </c:forEach>
                            </div>
                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                <h6>리뷰 ( <c:out value="${productDetails.reviewCount}"/> )</h6>
                                <p>리뷰쓰</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script>
      document.addEventListener('DOMContentLoaded', function() {
        // 'color__radio' 이름을 가진 모든 라디오 버튼에 대해 반복
        const colorRadios = document.getElementsByName('color__radio');
        Array.prototype.forEach.call(colorRadios, function(radio) {
          // 클릭 이벤트 리스너 추가
          radio.addEventListener('click', function() {
            // 클릭된 라디오 버튼을 'checked' 상태로 설정
            this.checked = true;
          });
        });

        // 'size__radio' 이름을 가진 모든 라디오 버튼에 대해 반복
        const sizeRadios = document.getElementsByName('size__radio');
        Array.prototype.forEach.call(sizeRadios, function(radio) {
          // 클릭 이벤트 리스너 추가
          radio.addEventListener('click', function() {
            // 클릭된 라디오 버튼을 'checked' 상태로 설정
            this.checked = true;

            // 모든 라디오 버튼의 레이블에서 'active' 클래스 제거
            sizeRadios.forEach(function(otherRadio) {
              otherRadio.parentNode.classList.remove('active');
            });

            // 클릭된 라디오 버튼의 레이블에 'active' 클래스 추가
            this.parentNode.classList.add('active');
        });
      });
    });
    </script>
</body>
