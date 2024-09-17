<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>DASHMIN - Bootstrap Admin Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="./assets/admin/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="./assets/admin/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="./assets/admin/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="./assets/admin/css/style.css" rel="stylesheet">
</head>

<body>
    <div class="container-xxl position-relative bg-white d-flex p-0">

        <!-- Sidebar Start -->
        <%@include file="../inc/siderBar.jsp" %>
        <!-- Sidebar End -->

        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
            <%@include file="../inc/navBar.jsp" %>
            <!-- Navbar End -->

            <!-- Table Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    <div class="col-12">
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4">Product Add</h6>
                            <c:if test="${not empty error}">
                                <span class="error">${error}</span>
                            </c:if>
                            <c:remove var="error" scope="session"/>
                            <form action="CreateProductServlet" method="post">
                                <div class="mb-3">
                                    <label for="exampleInputName" class="form-label">Name</label>
                                    <input name="name" type="text" class="form-control" id="exampleInputName" aria-describedby="nameHelp">
                                </div>

                                <div class="mb-3">
                                    <label for="exampleInputDescription" class="form-label">Description</label>
                                    <textarea name="description" class="form-control" id="exampleInputDescription" rows="4" aria-describedby="descriptionHelp"></textarea>
                                </div>
                                <div class="mb-3">
                                    <label for="exampleInputThumbnail" class="form-label">Thumbnail</label>
                                    <input name="thumbnail" type="text" class="form-control" id="exampleInputThumbnail" aria-describedby="thumbnailHelp">
                                </div>


                                <div class="mb-3">
                                    <label for="exampleInputPrice" class="form-label">Price</label>
                                    <input name="price" type="text" class="form-control" id="exampleInputPrice" aria-describedby="priceHelp">
                                </div>

                                <div class="mb-3">
                                    <label for="exampleInputQuantity" class="form-label">Quantity</label>
                                    <input name="quantity" type="number" class="form-control" id="exampleInputQuantity" aria-describedby="quantityHelp">
                                </div>

                                <div class="mb-3">
                                    <label for="exampleInputCategoryId" class="form-label">Category ID</label>
                                    <select name="categoryId" class="form-control" id="exampleInputCategoryId">
                                        <c:forEach items="${categoryList}" var="category">
                                            <option value="${category.id}">${category.name}</option>
                                        </c:forEach> 
                                    </select>
                                </div>

                                <button type="submit" class="btn btn-primary">Submit</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Table End -->

            <!-- Footer Start -->
            <%@include file="../inc/footer.jsp" %>
            <!-- Footer End -->
        </div>
        <!-- Content End -->

        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="./assets/admin/lib/chart/chart.min.js"></script>
    <script src="./assets/admin/lib/easing/easing.min.js"></script>
    <script src="./assets/admin/lib/waypoints/waypoints.min.js"></script>
    <script src="./assets/admin/lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="./assets/admin/lib/tempusdominus/js/moment.min.js"></script>
    <script src="./assets/admin/lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="./assets/admin/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="./assets/admin/js/main.js"></script>
</body>

</html>
