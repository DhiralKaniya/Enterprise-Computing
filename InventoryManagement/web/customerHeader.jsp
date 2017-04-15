           <!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="materialize.min.js"></script>
<script type="text/javascript">
     $(document).ready(function(){
      $('.carousel').carousel();
    });
</script>
<script type="text/javascript">
                        $(".button-collapse").sideNav();
                        $('.button-collapse').sideNav({
                             menuWidth: 300, // Default is 300
                             edge: 'right', // Choose the horizontal origin
                             closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
                             draggable: true // Choose whether you can drag to open on touch screens
                           }
                         );
                          $(document).ready(function() {
                            $('select').material_select();
                          });

                         // Show sideNav
                         $('.button-collapse').sideNav('show');
                         // Hide sideNav
                         $('.button-collapse').sideNav('hide');
                         // Destroy sideNav
                         $('.button-collapse').sideNav('destroy');
                         <%
                             String str = "tab_id";
                             try{
                               if(request.getAttribute("display") != null){
                                   str = request.getAttribute("display")+"";
                               }
                              //System.out.println(str);
                             }catch(Exception e){}
                         %>
                       $(document).ready(function(){
                        $('ul.tabs').tabs('select_tab', '<%=str %>');
                      });
                            
                      
 </script> 
 <%
     String username =(String) request.getSession().getAttribute("user");
 %>

<div class="row">

      <div class="col s12">
          <nav>
            <div class="nav-wrapper">
              <a href="Home.jsp" class="brand-logo center">Inventory Manage System</a>
              <ul id="nav-mobile" class="right hide-on-med-and-down">
                  <li><a class="dropdown-button" href="#!" data-activates="dropdown1"><i class="material-icons right">arrow_drop_down</i><%=username %></a></li>
                    <ul id='dropdown1' class='dropdown-content'>
                      <li><a href="">Profile</a></li>
                      <li><a href="Shoppingcart.jsp">MyCart</a></li>
                      <li><a href="Order.jsp">MyOrder</a></li>                                            
                      <li><a href="Controller?action=logout">logout</a></li>

                    </ul>
              </ul>
            </div>
        </nav>
       