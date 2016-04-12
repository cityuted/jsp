<jsp:include page="header.jsp"/>
<%@ page import="bean.Toy" %>
<%@ page import="bean.Template" %>
<jsp:useBean id="toys" class="bean.Toys" scope="request"/>
<!--==============================content================================-->
<section id="content" class="cont_pad">
    <div class="breadcrump">
        <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">Shop</a></li>
            <li>Toys on SALE</li>
        </ul>
    </div>
    <div class="row">
        <article class="grid_8">
            <h2 class="ind1"><%=request.getAttribute("pageFor")%></h2>
            <figure class="category_image"><img src="images/category_img1.png" alt=""></figure>
            <div class="sorting_block">
                <form id="sort">
                    <label class="criterion">
                        <span>Sort by:</span>
                        <a href="javascript:;" class="slct3">Alphabetically</a>
                        <ul class="drop3">
                            <li><a href="javascript:;">Alphabetically</a></li>
                            <li><a href="javascript:;">Default</a></li>
                            <li><a href="javascript:;">Alphabetically</a></li>
                            <li><a href="javascript:;">Most recent</a></li>
                            <li class="last_item"><a href="javascript:;">Price</a></li>
                        </ul>
                        <input type="hidden" id="select3" />
                        <div class="clear"></div>
                    </label>
                    <label class="show">
                        <span>Show:</span>
                        <a href="javascript:;" class="slct4">8</a>
                        <ul class="drop4">
                            <li><a href="javascript:;">8</a></li>
                            <li><a href="javascript:;">16</a></li>
                            <li><a href="javascript:;">32</a></li>
                            <li><a href="javascript:;">64</a></li>
                            <li class="last_item"><a href="javascript:;">All</a></li>
                        </ul>
                        <input type="hidden" id="select4" />
                        <div class="clear"></div>
                    </label>
                    <div class="clear"></div>
                </form>
                <form id="view">
                    <label>
                        <span>View as:</span>
                        <a class="active view_icon1" href="javascript:view('grid');" class="view_icon1"></a>
                        <a href="javascript:view('list');" class="view_icon2"></a>
                    </label>
                </form>
                <div class="clear"></div>
            </div>
            <ul id="category" class="grid">
                <%
                    for(int i=0;i<toys.getToys().size();i++){
                        Toy toy = toys.getToys().get(i);
                        out.print(Template.getToyTemplate(toy.getToyIcon(),toy.getToyName(),String.valueOf(toy.getCashpoint()),String.valueOf(toy.getToyID())));
                    }
                %>

            </ul>
            <div class="categories_nav wrapper">
                <div class="showing">Showing 1 to 12 of 18 (2 Pages)</div>
                <div class="buttons">
                    <a href="#" class="prev"></a>
                    <a href="#">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#" class="next"></a>
                    <a href="#" class="end"></a>
                </div>
            </div>
        </article>
        <article class="grid_4">
            <h3 class="ind">Categories</h3>
            <ul class="categories sf-menu">
                <li><a href="#">Toys on SALE</a></li>
                <li><a href="#">Toys by Age</a></li>
                <li><a href="#">Animals &amp; Wildfire</a></li>
                <li><a href="#">Arts, Crafts &amp; Music</a></li>
                <li><a href="#">Bath Toys</a></li>
                <li><a href="#">Books</a>
                    <ul>
                        <li><a href="#">Plastic</a></li>
                        <li><a href="#">Rubber</a></li>
                        <li><a href="#">Soft</a></li>
                        <li><a href="#">Wooden</a></li>
                    </ul>
                </li>
                <li><a href="#">Building Blocks</a></li>
                <li><a href="#">Classic &amp; Retro</a></li>
                <li><a href="#">Cool Vehicles</a></li>
                <li><a href="#">Games</a></li>
                <li><a href="#">Outdoor Toys</a></li>
                <li class="last_item"><a href="#">Party Favors</a></li>
            </ul>
            <a href="#" class="link1">View All</a>
            <div class="price_filter">
                <h3 class="green ind">Filter by Price</h3>
                <form action="#" method="post">
                    <div class="sliderCont">
                        <div id="price_slider"></div>
                    </div>
                    <div class="formCost">
                        <span>Filter</span>
                        <label>
                            Price:
                            $<input type="text" id="minCost" value="0"/>
                            &mdash;
                            $<input type="text" id="maxCost" value="1999"/>
                        </label>
                    </div>
                </form>
            </div>
            <div class="featured_product">
                <h3 class="pink bg_none">Top rated products</h3>
                <ul class="ext_list">
                    <li>
                        <figure><a href="#"><img src="images/f_product1.jpg" alt=""></a></figure>
                        <div>
                            <h4><a href="#">Colorful toy truck</a></h4>
                            <div class="price">$21</div>
                        </div>
                    </li>
                    <li>
                        <figure><a href="#"><img src="images/f_product2.jpg" alt=""></a></figure>
                        <div>
                            <h4><a href="#">Fancy giraffe toy</a></h4>
                            <div class="price">$8</div>
                        </div>
                    </li>
                    <li class="bg_none">
                        <figure><a href="#"><img src="images/f_product3.jpg" alt=""></a></figure>
                        <div>
                            <h4><a href="#">Children soft toy</a></h4>
                            <div class="price">$15</div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="tags">
                <h3 class="blue ind">Product Tags</h3>
                <ul class="tags">
                    <li>
                        <a href="#">Animals <span>(54)</span></a>
                        <a href="#">Arts <span>(12)</span></a>
                        <a href="#">Bath toys<span>(33)</span></a>
                    </li>
                    <li>
                        <a href="#">Books <span>(276)</span></a>
                        <a href="#">Biulding blocks <span>(17)</span></a>
                        <a href="#">Classic <span>(82)</span></a>
                    </li>
                    <li>
                        <a href="#">Colorful <span>(106)</span></a>
                        <a href="#">Crafts <span>(29)</span></a>
                        <a href="#">Games <span>(77)</span></a>
                    </li>
                    <li>
                        <a href="#">Outdoor <span>(23)</span></a>
                        <a href="#">Crafts <span>(29)</span></a>
                        <a href="#">Games <span>(77)</span></a>
                    </li>
                    <li>
                        <a href="#">Soft <span>(41)</span></a>
                        <a href="#">Vechicles <span>(36)</span></a>
                        <a href="#">Wooden <span>(25)</span></a>
                    </li>
                </ul>
            </div>
        </article>
    </div>
</section>
</div>
<!--==============================footer=================================-->
<jsp:include page="footer.jsp"/>