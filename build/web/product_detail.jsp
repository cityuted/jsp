<jsp:include page="header.jsp"/>
<%@ page import="bean.Template" %>
<%@ page import="bean.Message" %>
<jsp:useBean id="toy" class="bean.Toy" scope="request"/>
<jsp:useBean id="messages" class="bean.Messages" scope="request"/>
    <!--==============================content================================-->
      <section id="content" class="cont_pad">
          <div class="breadcrump">
            <ul>
              <li><a href="#">Home</a></li>
              <li><a href="#">Shop</a></li>
              <li><a href="#">Toys on SALE</a></li>
              <li><%=toy.getToyName()%></li>
            </ul>
          </div>
          <div class="row product">
            <article class="grid_8">
              <div class="row">
                <article class="grid_4">
                  <div class="product_gallery">
                    <div id="slider" class="flexslider">
                       <img width="100%"src="images/<%=toy.getToyIcon()%>" />
                    </div>  
                  </div>  
                </article>
                <article class="grid_4">
                  <h2 class="black"><%=toy.getToyName()%></h2>
                    <div class="product_info">
                      <div class="rating">
                        <span class="active"></span>
                        <span class="active"></span>
                        <span class="active"></span>
                        <span></span>
                        <span></span>
                      </div>
                      <div class="review">
                        <a href="#"><%=messages.getMessages().size()%> Review(s)</a>&nbsp;
                        <a href="#" class="write_view">Write a Review</a>
                      </div>
                    </div>
                    <div class="description">
                      <%=toy.getDescription()%> 
                    </div>
                    <div class="price">$25</div>
                    <div class="product_cart">
                      <div class="qty">
                        <span>Quantity:</span>
                        <label>
                          <input type="text" value="1" size="2" name="quantity" class="w30" id="qty">
                          <a href="javascript:void(0);" class="qtyBtn mines"></a>
                          <a href="javascript:void(0);" class="qtyBtn plus"></a>
                        </label>
                        <a href="#" class="add_product"><em></em>Add to Cart</a>
                      </div>
                    </div>
                    <div class="social_btns">
                      <!-- AddThis Button BEGIN -->
                      <div class="addthis_toolbox addthis_default_style "> <a class="addthis_button_facebook_like" fb:like:layout="button_count"></a> <a class="addthis_button_tweet"></a> <a class="addthis_button_pinterest_pinit"></a> <a class="addthis_counter addthis_pill_style"></a> </div>
                      <script type="text/javascript" src="../../s7.addthis.com/js/300/addthis_widget.js#pubid=xa-506f325f57fbfc95"></script>
                      <!-- AddThis Button END -->   
                    </div>
                    <dl class="tags1">
                      <dd>Category: <a href="#">Toys on SALE</a>, <a href="#">Classic &amp; Retro</a></dd>
                      <dd>Tags: <a href="#">classic</a>, <a href="#">music</a>, <a href="#">plastic</a>, <a href="#">sale</a>,</dd>
                    </dl>
                </article>
              </div>
              <!-- tabs -->
              <div class="responsive-tabs fw_page">
                <h2>Description</h2>
                <div>
                  <div class="inner">
                    <p><%=toy.getDescription()%> 
                  </div>
                </div>
          
                <h2>Additional Info</h2>
                <div>
                  <dl class="add_info">
                    <dd><strong>Size:</strong>Big</dd>
                    <dd><strong>Color:</strong>Colorful</dd>
                    <dd class="last"><strong>Material:</strong>Plastic</dd>
                  </dl>
                </div>
                <h2>Reviews (3)</h2>
                <div>
                  <div class="review_info">
                    <div class="qty_review">
                      <strong>3 reviews for <%=toy.getToyName()%></strong>
                    </div>
                    <div class="rating average_rating">
                      <em>Average Rating:</em>
                      <span class="active"></span>
                      <span class="active"></span>
                      <span class="active"></span>
                      <span class="active"></span>
                      <span></span>
                    </div>
                  </div>
                  <ul class="ext_list review_list">
                     <%
                         for(int i=0;i<messages.getMessages().size();i++){
                             Message m = messages.getMessages().get(i);
                             out.print(Template.getMessageTemplate("123", m.getContent(), "date", 3));
                         }
                     %>

                  </ul>
                  <a href="#" class="add_review button">Add a Review</a>
                </div>
              </div>
              <div class="related_products">
                <h2 class="pink ind">Related Products</h2>
                <ul id="category" class="grid last bd_n related">
                  <li>
                    <div>
                      <figure><a href="#"><img src="images/bestsell1.jpg" alt=""></a></figure>
                      <div>
                        <h4><a href="#">Bear soft toy</a></h4>
                        <div class="description">
                          Fusce euismod consequat ante. Lorem ipsum dolor sit amet, consectetuer adipisMauris accumsan nulla vel diam. Sed in lacus ut enim adipiscing aliquet.
                        </div>
                        <div class="price">$25</div>
                        <div class="product_buttons">
                          <a href="#" class="add_to_cart"></a>
                          <a href="#" class="detail_view">Details</a>
                        </div>  
                      </div>
                    </div>
                  </li>
                  <li>
                    <div>
                      <span class="new_label">New</span>
                      <figure><a href="#"><img src="images/bestsell2.jpg" alt=""></a></figure>
                      <div>
                        <h4><a href="#">Wooden toy</a></h4>
                        <div class="description">
                          Nulla venenatis. In pede mi, aliquet sit amet, euismod in,auctor ut, ligula. Aliquam dapibus tincidunt metus. Praesent justo dolor, lobortis quis, lobortis dignissim, pulvinar ac, lorem. 
                        </div>
                        <div class="price">$32</div>
                        <div class="product_buttons">
                          <a href="#" class="add_to_cart"></a>
                          <a href="#" class="detail_view">Details</a>
                        </div>  
                      </div>
                    </div>
                  </li>
                  <li>
                    <div>
                      <figure><a href="#"><img src="images/bestsell3.jpg" alt=""></a></figure>
                      <div>
                        <h4><a href="#">Wooden toy</a></h4>
                        <div class="description">
                          Nulla venenatis. In pede mi, aliquet sit amet, euismod in,auctor ut, ligula. Aliquam dapibus tincidunt metus. Praesent justo dolor, lobortis quis, lobortis dignissim, pulvinar ac, lorem. 
                        </div>
                        <div class="price">$32</div>
                        <div class="product_buttons">
                          <a href="#" class="add_to_cart"></a>
                          <a href="#" class="detail_view">Details</a>
                        </div>  
                      </div>
                    </div>
                  </li>
                  <li>
                    <div>
                      <figure><a href="#"><img src="images/bestsell4.jpg" alt=""></a></figure>
                      <div>
                        <h4><a href="#">Wooden toy</a></h4>
                        <div class="description">
                          Nulla venenatis. In pede mi, aliquet sit amet, euismod in,auctor ut, ligula. Aliquam dapibus tincidunt metus. Praesent justo dolor, lobortis quis, lobortis dignissim, pulvinar ac, lorem. 
                        </div>
                        <div class="price">$32</div>
                        <div class="product_buttons">
                          <a href="#" class="add_to_cart"></a>
                          <a href="#" class="detail_view">Details</a>
                        </div>  
                      </div>
                    </div>
                  </li>
                </ul>
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
              <div class="banner5">
                <a href="#"><img src="images/banner3.png" alt=""><span><img src="images/banner3_h.png" alt=""></span></a>
              </div>
              <div class="featured_product m_bottom_zero">
                <h3 class="blue bg_none">Recently Viewed</h3>
                <ul class="ext_list">
                  <li>
                    <figure><a href="#"><img src="images/f_product1.jpg" alt=""></a></figure>
                    <div>
                      <h4><a href="#">Colorful toy truck</a></h4>
                      <div class="price">$21</div>
                      <div class="rating">
                        <span class="active"></span>
                        <span class="active"></span>
                        <span class="active"></span>
                        <span class="active"></span>
                        <span class="active"></span>
                      </div>
                    </div>
                  </li>
                  <li>
                    <figure><a href="#"><img src="images/f_product2.jpg" alt=""></a></figure>
                    <div>
                      <h4><a href="#">Fancy giraffe toy</a></h4>
                      <div class="price">$8</div>
                      <div class="rating">
                        <span class="active"></span>
                        <span class="active"></span>
                        <span class="active"></span>
                        <span class="active"></span>
                        <span class="active"></span>
                      </div>
                    </div>
                  </li>
                  <li class="bg_none">
                    <figure><a href="#"><img src="images/f_product3.jpg" alt=""></a></figure>
                    <div>
                      <h4><a href="#">Children soft toy</a></h4>
                      <div class="price">$15</div>
                      <div class="rating">
                        <span class="active"></span>
                        <span class="active"></span>
                        <span class="active"></span>
                        <span></span>
                        <span></span>
                      </div>
                    </div>
                  </li>
                </ul>
              </div>
            </article>
          </div>
      </section>
  </div>
  <!--==============================footer=================================-->
<jsp:include page="footer.jsp"/>