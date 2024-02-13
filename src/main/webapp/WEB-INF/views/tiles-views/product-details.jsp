<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../../../resources/css/product-details-review-paging.css">
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
                        <input type="hidden" id="productId" name="productId" value="${productDetails.product.productId}">
                        <h3><c:out value="${productDetails.product.productName}"/> </h3>
                        <div class="product__details__button">
                            <ul>
                                <li><a href="#"><span class="icon_heart_alt"></span></a></li>
                            </ul>
                        </div>
                        <div class="rating">
                            <c:forEach var="i" begin="1" end="5" step="1">
                                <c:choose>
                                    <c:when test="${i <= productDetails.countAvgRatingDto.avgRating}">
                                        <i class="fa fa-star"></i>
                                    </c:when>
                                    <c:when test="${i - productDetails.countAvgRatingDto.avgRating < 1}">
                                        <i class="fa fa-star-half-o"></i>
                                    </c:when>
                                    <c:otherwise>
                                        <i class="fa fa-star-o"></i>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <span>( <c:out value="${productDetails.countAvgRatingDto.reviewCount}"/> reviews )</span>
                        </div>
                        <div class="product__details__price"><c:out value="${productDetails.product.price} 원"/> </div>
                        <div class="product__details__button">
                            <div class="quantity">
                                <span>Quantity:</span>
                                <div class="pro-qty">
                                    <span class="dec qtybtn" id="decrement">-</span>
                                    <input type="text" id="quantity" value="1">
                                    <span class="inc qtybtn" id="increment">+</span>
                                </div>
                            </div>
                            <a href="#" class="cart-btn"><span class="icon_bag_alt"></span> 장바구니 추가 </a>
                            <div class="checkout__order__widget">
                                <a href="#" class="checkout__order__widget"><span class="icon_bag_alt"></span> 구매하기 </a>
                            </div>
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
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab" aria-selected="false">리뷰 ( <c:out value="${productDetails.countAvgRatingDto.reviewCount}"/> )</a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
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

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script type="application/javascript" src="../../../resources/js/product-details-function.js"></script>
    <script type="application/javascript" src="../../../resources/js/product-details-reviews.js"></script>
</body>
