<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cara</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
              integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/css/style_1.css">
    </head>

    <body>

        <%@include file="inc/header.jsp" %>
        <section id="page-header">
            <h2>#${keyword}</h2>
            <p>Save more with coupons & up to 70% off!</p>
            <form action="SearchServlet" class="search" method="get">
                <div class="form-search">
                    <input name="keyword" class="search w-50 p-2 rounded-top" type="search" placeholder="Search" aria-label="Search">
                </div>
            </form>
        </section>

        <section id="product1" class="section-p1">
            <form action="ShopServlet" class="filter d-flex" style="width: 50%;" method="get">
                <input type="hidden" name="categoryId" value="${category.id}"/>

                <!-- Sort By Dropdown -->
              <select name="sort" class="form-select me-2" aria-label="Sort By">
                        <option value="name" <c:if test="${param.sort == 'name'}">selected</c:if>>Sort By Name</option>
                        <option value="price" <c:if test="${param.sort == 'price'}">selected</c:if>>Sort By Price</option>
                        <option value="createdAt" <c:if test="${param.sort == 'createdAt'}">selected</c:if>>Sort By Time</option>
                        </select>
                        <select name="order" class="form-select" aria-label="Order By">
                            <option value="ASC" <c:if test="${param.order == 'ASC'}">selected</c:if>>A->Z</option>
                        <option value="DESC" <c:if test="${param.order == 'DESC'}">selected</c:if>>Z->A</option>
                        </select>
                    <button type="submit" class="filter-submit btn btn-primary">Filter</button>
                </form>

                <div class="prod-cont">
                <c:forEach items="${ProductList}" var="product">
                    <div class="prod">
                        <a href="ProductServelt?productId=${product.id}">
                            <img src="${product.thumbnail}" alt="">
                        </a>
                        <div class="des">
                            <span>adidas</span>
                            <h5>${product.name}</h5>
                            <div class="star">
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                            </div>
                            <h4>${product.price}</h4>
                        </div>
                        <a href="#"><i class="fa-solid fa-cart-shopping cart"></i></a>
                    </div>
                </c:forEach>
            </div>
        </section>

        <section id="pagination" class="section-p1">
            <c:forEach var="i" begin="1" end="${totalPages}">
                <a href="ShopServlet?page=${i}" <c:if test="${i == currentPage}">class="active bg-secondary"</c:if>>${i}</a>
            </c:forEach>
            <a href="ShopServlet?page=${currentPage + 1}" <c:if test="${currentPage == totalPages}">class="disabled"</c:if>><i class="fa-solid fa-arrow-right"></i></a>
        </section>

        <section id="newsletter" class="section-p1 section-m1">
            <div class="newstext">
                <h4>Sign Up For Newsletters</h4>
                <p>Get E-mail updates about our latest shop and <span>special offers</span></p>
            </div>
            <div class="form">
                <input type="text" placeholder="Your email address">
                <button class="normal">Sign up</button>
            </div>
        </section>

        <footer class="section-p1">
            <!-- Footer Content -->
        </footer>

    </body>

</html>
