<%@page import="bean.Template"%>
<jsp:include page="header.jsp"/>
<script>
    document.getElementById("lihome").className += " current";
</script>
<!--==============================content================================-->

<section id="content" class="cont_pad">

    <div class="row m_bot1 slider_row">

        <article class="grid_8">

            <div class="fluidHeight">

                <div class="sliderContainer">

                    <div class="iosSlider">

                        <div class="slider">

                            <div class="item">

                                <img src="images/slide1.png">

                                <div class="m-caption caption1">

                                    <span class="font1">The</span>

                                    <span class="font2">GOOD</span>

                                    <span class="font3">Toys</span>

                                    <span class="font4">At The</span>

                                    <span class="font5">RIGHT</span>

                                    <span class="font6">Time!</span>

                                    <a href="#" class="slide_button">Click Here</a>

                                </div>

                                <a href="#"><img src="images/slide1_s.png"></a>

                            </div>

                            <div class="item">

                                <img src="images/slide2.png">

                                <div class="m-caption caption2">

                                    <span class="font1">Big</span>

                                    <span class="font2">sale</span>

                                    <span class="font3">up <span>to</span></span>

                                    <span class="font4">-50%</span>

                                    <span class="font5">on</span>

                                    <span class="font6">Clothes</span>

                                    <a href="#" class="slide_button">Shop Now</a>

                                </div>

                                <a href="#"><img src="images/slide2_s.png"></a>

                            </div>

                            <div class="item">

                                <img src="images/slide3.png">

                                <div class="m-caption caption3">

                                    <span class="font1">Powerful</span>

                                    <span class="font2">tractor</span>

                                    <span class="font3">for <span>only</span></span>

                                    <span class="font4">$</span>

                                    <span class="font5">39.99</span>

                                    <a href="#" class="slide_button">Buy now</a>

                                </div>

                                <a href="#"><img src="images/slide3_s.png"></a>

                            </div>

                        </div>

                        <div class = 'prevContainer'>

                            <div class = 'prev'></div>

                        </div>

                        <div class = 'nextContainer'>

                            <div class = 'next'></div>

                        </div>

                        <div class = 'selectorsBlock'>

                            <div class = 'selectors'>

                                <div class = 'item selected'></div>

                                <div class = 'item'></div>

                                <div class = 'item'></div>

                            </div>

                        </div>

                    </div>

                </div>

            </div>

        </article>

        <article class="grid_4">

            <ul class="banners1">

                <li>

                    <div class="banner1">

                        <a href="#"><img src="images/banner1.png" alt=""><span><img src="images/banner1_h.png" alt=""></span></a>

                    </div>

                </li>

                <li>

                    <div class="banner2">

                        <a href="#"><img src="images/banner2.png" alt=""><span><img src="images/banner2_h.png" alt=""></span></a>

                    </div>

                </li>

                <li class="last">

                    <div class="banner3">

                        <a href="#"><img src="images/banner3.png" alt=""><span><img src="images/banner3_h.png" alt=""></span></a>

                    </div>

                </li>

            </ul>

        </article>

    </div>

    <div class="row latest_product_box">

        <article class="grid_12">

            <h2 class="ind pink">Bestsellers</h2>

            <div class="carousel_box list_carousel responsive">

                <a class="carousel_btn car_prev" id="car_prev" href="#"></a>

                <a class="carousel_btn car_next" id="car_next" href="#"></a>

                <ul id="latest_products">

                    <%
                        out.print(Template.getLatest());
                        out.print(Template.getLatest());
                        out.print(Template.getLatest());
                        out.print(Template.getLatest());
                        out.print(Template.getLatest());
                        out.print(Template.getLatest());
                        out.print(Template.getLatest());
                    %>

                </ul>

            </div>

        </article>

    </div>

    <div class="row">

        <article class="grid_12">

            <h2 class="ind">Second Hand Toy</h2>

            <div class="carousel_box list_carousel responsive last">

                <a class="carousel_btn car_prev" id="car_prev1" href="#"></a>

                <a class="carousel_btn car_next" id="car_next1" href="#"></a>

                <ul id="bestsellers">

<%
out.print(Template.getBestSell());
out.print(Template.getBestSell());
out.print(Template.getBestSell());
out.print(Template.getBestSell());
out.print(Template.getBestSell());
%>



                </ul>

            </div>

        </article>

    </div>

</section>

</div>
<!--==============================footer=================================-->
<jsp:include page="footer.jsp"/>
