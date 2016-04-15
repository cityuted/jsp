<jsp:include page="header.jsp"/>
<script>
    document.getElementById("lishop").className += " current";
</script>
<%@ page import="bean.Toy" %>
<%@ page import="bean.Template" %>
<jsp:useBean id="toys" class="bean.Toys" scope="request"/>
<!--==============================content================================-->
<section id="content" class="cont_pad">
    <div class="breadcrump">
        <ul>
            <li><a href="#">Shop<%=request.getQueryString()%></a></li>
        </ul>
    </div>
    <div class="row">
        <form id="formSort" action="/toy/Category" method="get">
            <%
                String[] sQuery = request.getQueryString().split("&");
                for (int i = 0; i < sQuery.length; i++) {
                    String[] sQueryV = sQuery[i].split("=");
                    out.print("<input type=\"hidden\" id='" + sQueryV[0] + "' name=\"" + sQueryV[0] + "\" value='" + sQueryV[1] + "' />");
                }
            %>
        </form>
        <article class="grid_8">
            <h2 class="ind1"><%=request.getAttribute("pageFor")%></h2>
            <figure class="category_image"><img src="images/category_img1.png" alt=""></figure>
            <div class="sorting_block">
                <form id="sort">
                    <label class="criterion">
                        <span>Sort by:</span>
                        <a id="sortDisplay" href="javascript:;"  class="slct3">Toy Name</a>
                        <ul class="drop3">
                            <li onclick="document.getElementById('sort').value = 'TOYNAME';"><a href="javascript:;">Toy Name</a></li>
                            <li onclick="document.getElementById('sort').value = this.childNodes[0].innerHTML;"><a href="javascript:;">Sales</a></li>
                            <li onclick="document.getElementById('sort').value = 'CASHPOINT';"><a href="javascript:;">Cash Point</a></li>
                        </ul>
                        <input type="hidden" id="select3" />
                        <div class="clear"></div>
                    </label>
                    <label class="criterion">
                        <span></span>
                        <a id="orderDisplay" href="javascript:;" class="slct4">Asc</a>
                        <ul class="drop4">
                            <li onclick="document.getElementById('order').value = 'asc';"><a href="javascript:;">Ascending</a></li>
                            <li onclick="document.getElementById('order').value = 'desc';"><a href="javascript:;">Descending</a></li>
                        </ul>
                        <input type="hidden" id="select4" />
                        <div class="clear"></div>
                    </label>






                    <a href="javascript:;" style="margin: -5px 0 0 11px;" onclick="document.getElementById('formSort').submit();" class="button">Sort</a>


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
                    for (int i = 0; i < toys.getToys().size(); i++) {
                        Toy toy = toys.getToys().get(i);
                        out.print(Template.getToyTemplate(toy.encodedImage(), toy.getToyName(), String.valueOf(toy.getCashpoint()), String.valueOf(toy.getToyID())));
                    }
                %>

            </ul>
            <div class="categories_nav wrapper">
                <%
                    int pageCount = (toys.getToys().size() / 8);
                    int pageNum = 1;
                    int from = (pageNum - 1) * 8 + 1;

                    int end = pageNum * 8;
                    if (toys.getToys().size() < 8) {
                        end = toys.getToys().size();
                    }
                    if (toys.getToys().size() % 8 != 0) {
                        pageCount += 1;
                    }
                    out.println("<div class=\"showing\">Showing " + from + " to " + end + " of " + toys.getToys().size() + " (" + pageCount + " Pages)</div>");


                %>
                <div class="buttons">
                    <a href="#" class="prev"></a>
                    <%                        

                        for (int i = 0; i < pageCount; i++) {
                            out.print(" <a href=\"#\">"+(i+1)+"</a>");
                        }
                    %>
                    <a href="#" class="next"></a>
                    <a href="#" class="end"></a>
                </div>
            </div>
            <script>
                var sort="";
                var order="";
                if(document.getElementById("sort").value==='TOYNAME'){
                    sort='Toy Name';
                }
                if(document.getElementById("sort").value==='CASHPOINT'){
                    sort='Cash Point';
                }
                if(document.getElementById("sort").value==='Sales'){
                    sort='Sales';
                }
                if(document.getElementById("order").value==='asc'){
                    order='Ascending';
                }
                if(document.getElementById("order").value==='desc'){
                    order='Descending';
                }
                document.getElementById("sortDisplay").innerHTML = sort;
                document.getElementById("orderDisplay").innerHTML = order;
            </script>
        </article>
        <article class="grid_4">
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

        </article>
    </div>
</section>
</div>
<!--==============================footer=================================-->
<jsp:include page="footer.jsp"/>