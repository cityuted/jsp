<%-- 
    Document   : slider
    Created on : 2016/4/8, 下午 12:37:04
    Author     : Mesong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/toy/backend/dist/img/avatar5.png" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${username}</p>
                <a href="/toy/backend/#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- search form -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
                    <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                    </button>
                </span>
            </div>
        </form>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <li class="treeview" id="toy">
                <a href="/toy/doSearchToy">
                    <i class="fa fa-folder"></i> <span>Toy Records</span> <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li id="toyMenu"><a href="/toy/doSearchToy"><i class="fa fa-circle-o"></i> Toy</a></li>
                    <li id="secondHandMenu"><a href="/toy/doSearchSecondHand"><i class="fa fa-circle-o"></i> Second-hand toy</a></li>
                    <li id="categoryMenu"><a href="/toy/doSearchToyCategory"><i class="fa fa-circle-o"></i> Toy Category</a></li>
                    
                </ul>

               
            </li>
            <li class="treeview" id="cust">
                <a href="/toy/doSearchTransaction">
                    <i class="fa fa-user"></i> <span>Customer Records</span> <i class="fa fa-angle-left pull-right"></i>
                </a>
                 <ul class="treeview-menu">
                    <li id="transactionMenu"><a href="/toy/doSearchTransaction"><i class="fa fa-circle-o"></i> Transaction Header</a></li>
                    <li id="customerMenu"><a href="/toy/doSearchCustomer"><i class="fa fa-circle-o"></i> Customer Profile</a></li>
                    <li id="commentMenu"><a href="/toy/doSearchComment"><i class="fa fa-circle-o"></i> Comment</a></li>
                 </ul>
                
                
                
            </li>
             

            <li class="header">LABELS</li>
            <li><a href="/toy/backend/#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
            <li><a href="/toy/backend/#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
            <li><a href="/toy/backend/#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
