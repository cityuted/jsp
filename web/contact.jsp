<jsp:include page="header.jsp"/>
  <!--==============================content================================-->
      <section id="content" class="cont_pad">
        <div class="breadcrump">
          <ul>
            <li><a href="#">Home</a></li>
            <li>Contact</li>
          </ul>
        </div>
        <div class="row">
          <article class="grid_8">
            <h2 class="blue ind1">Store Locations</h2>
            <figure class="img_wrap1 map_wrapper">
                <iframe id="map_canvas" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3690.436139767711!2d114.1706183149554!3d22.337154985304455!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3404073400f3ef35%3A0xeb61704ffb0ba959!2sCity+University+of+Hong+Kong!5e0!3m2!1szh-TW!2shk!4v1459880625633" width="600" height="450" frameborder="0" style="border:0" allowfullscreen"></iframe>
            </figure>
            <div class="row">
              <div class="grid_4">
                <dl class="adress">
                    <dt>City University of Hong Kong</dt>
                  <dt>83 Tat Chee Ave, Kowloon Tong</dt>
                  <dd><span>Phone:</span>+852 3442 8580</dd>
                  <dd><span>FAX:</span>+852 3442 0503</dd>
                  <dd>E-mail: <a href="#" class="link2">csadm@cityu.edu.hk</a></dd>
                </dl> 
              </div>
              <div class="grid_4">

              </div>
            </div>
          </article>
          <article class="grid_4">
            <h3 class="ind4 green1">Contact Form</h3>
            <p class="p2">Fields marked with <sup class="red">*</sup> are required.</p>
            <form id="contact-form">
              <div class="success">Contact form submitted!<br>
                  <strong>We will be in touch soon.</strong>
              </div>
              <fieldset>
                <label class="name">
                  Name <sup class="red">*</sup><br>
                  <input type="text" value="">
                  <span class="error">*This is not a valid name.</span> <span class="empty">*This field is required.</span>
                </label>
                <label class="email">
                   E-Mail <sup class="red">*</sup><br>
                  <input type="text" value="">
                    <span class="error">*This is not a valid email address.</span> <span class="empty">*This field is required.</span>
                </label>
                <label class="website notRequired">
                   Your Website <br>
                  <input type="text" value="">
                    <span class="error">*This is not a valid phone number.</span> <span class="empty">*This field is required.</span>
                </label>
                <label class="subject notRequired">
                   Subject <br>
                  <input type="text" value="">
                    <span class="error">*This is not a valid phone number.</span> <span class="empty">*This field is required.</span>
                </label>
                <label class="message notRequired">
                  Message<br>
                  <textarea></textarea>
                    <span class="error">*The message is too short.</span> <span class="empty">*This field is required.</span>
                </label>
                <div class="buttons2">
                    <a href="#" data-type="submit" class="button">Send Message</a>
                </div>
              </fieldset>
          </form>
          </article>
        </div>
      </section>
  </div>
  <!--==============================footer=================================-->
<jsp:include page="footer.jsp"/>