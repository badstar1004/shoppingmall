<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" type="text/css" href="../../../resources/css/product-list.css">
<body>
    <div class="container py-5">
        <div class="contentContainer" style="display: flex; flex-direction: column; align-items: center; margin-top: 30px;">
            <div class="row">
                <h2>
                    <span>
                        <a href="<c:url value="/categories?main=${categoryList.mainCategory.categoryId}"/>" style="color: black">
                            <c:out value="${categoryList.mainCategory.categoryName}"/>
                        </a>
                    </span>
                </h2>
            </div>
            <ul>
                <c:forEach items="${categoryList.subCategriesList}" var="subCategories">
                    <li style="display: inline; margin-right: 10px">
                        <a href="<c:url value="/categories?main=${subCategories.parentCategoryId}&sub=${subCategories.categoryId}"/>" style="color: black"><c:out value="${subCategories.categoryName}"/></a>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <!-- Product grid container -->
        <div class="product-grid">
            <c:if test="${not empty productList}">
                <c:forEach items="${productList}" var="product">
                    <div class="product-item">
                        <a href="<c:url value='/products/details/${product.productId}' />" class="product-link">
                            <img src="${product.imageUrl}" alt="${product.productName}">
                            <div><c:out value="${product.productName}"/></div>
                            <div><c:out value="${product.price}"/> 원</div>
                        </a>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${empty productList}">
                <div class="empty-category"><h3>상품이 없는 카테고리입니다.</h3></div>
            </c:if>
        </div>
        <!-- Pagination Controls -->
        <div>
            <c:if test="${not empty pagingHandle}">
                <div class="pagination">
                    <c:if test="${pagingHandle.showPrev}">
                        <a href="<c:url value='/categories?main=${param.main}&sub=${param.sub}&page=${pagingHandle.page - 1}' />" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </c:if>

                    <c:forEach begin="${pagingHandle.beginPage}" end="${pagingHandle.endPage}" var="pageNum">
                        <c:choose>
                            <c:when test="${pageNum == pagingHandle.page}">
                                <span><strong>${pageNum}</strong></span>
                            </c:when>
                            <c:otherwise>
                                <a href="<c:url value='/categories?main=${param.main}&sub=${param.sub}&page=${pageNum}' />">${pageNum}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <c:if test="${pagingHandle.showNext}">
                        <a href="<c:url value='/categories?main=${param.main}&sub=${param.sub}&page=${pagingHandle.page + 1}' />" aria-label="Next">
                            <span aria-hidden="true">&rsaquo;</span>
                        </a>
                    </c:if>
                </div>
            </c:if>
        </div>
    </div>
</body>
