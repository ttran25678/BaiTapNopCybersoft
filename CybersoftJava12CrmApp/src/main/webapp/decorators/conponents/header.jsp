<%@page import="java12.crmapp.util.Url"%>
<%@page import="java12.crmapp.util.Path"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
   <!-- Header -->
   <div id="header" class="mdk-header bg-dark js-mdk-header m-0" data-fixed data-effects="waterfall">
       <div class="mdk-header__content">
           <div class="navbar navbar-expand-sm navbar-main navbar-dark bg-dark pr-0" id="navbar" data-primary>
               <div class="container">
                   <!-- Navbar toggler -->

                   <button class="navbar-toggler navbar-toggler-right d-block d-md-none" type="button" data-toggle="sidebar">
                      <span class="navbar-toggler-icon"></span>
                   </button>

                   <!-- Navbar Brand -->
                   <a href="<%=request.getContextPath()+Path.HOME %>" class="navbar-brand">
                       <img class="navbar-brand-icon" src="assets/images/logo.png" height="50" alt="Cybersoft" />
                   </a>

                   <span class="mr-3"></span>

                   <form class="search-form d-none d-xl-flex flex mr-3" action="fixed-index.html">
                       <button class="btn" type="submit">
                           <i class="material-icons">search</i>
                       </button>
                       <input type="text" class="form-control" placeholder="Search" />
                   </form>

                   <ul class="nav navbar-nav ml-auto d-none d-md-flex border-left">
                       <li class="nav-item dropdown">
                           <a href="#notifications_menu" class="nav-link dropdown-toggle" data-toggle="dropdown" data-caret="false">
                               <i class="material-icons nav-icon navbar-notifications-indicator">
                                   notifications_none
                               </i>
                           </a>
                           <div id="notifications_menu" class="dropdown-menu dropdown-menu-right navbar-notifications-menu">
                               <div class="dropdown-item d-flex align-items-center py-2">
                                   <span class="flex navbar-notifications-menu__title m-0">
                                       Notifications
                                   </span>
                                   <a href="javascript:void(0)" class="text-muted">
                                       <small>Clear all</small>
                                   </a>
                               </div>
                               <div class="navbar-notifications-menu__content" data-perfect-scrollbar>
                                   <div class="py-2">
                                       <div class="dropdown-item d-flex">
                                           <div class="mr-3">
                                               <div class="avatar avatar-sm" style="width: 32px; height: 32px">
                                                   <img src="assets/images/256_daniel-gaffey-1060698-unsplash.jpg" alt="Avatar" class="avatar-img rounded-circle" />
                                               </div>
                                           </div>
                                           <div class="flex">
                                               <a href="">Tiến Hoàng</a> đã bình luận trong
                                               <a href="">Stack</a><br />
                                               <small class="text-muted">1 phút trước</small>
                                           </div>
                                       </div>
                                       <div class="dropdown-item d-flex">
                                           <div class="mr-3">
                                               <a href="#">
                                                   <div class="avatar avatar-xs" style="width: 32px; height: 32px">
                                                       <span class="avatar-title bg-purple rounded-circle">
                                                           <i class="material-icons icon-16pt">
                                                           person_add
                                                           </i>
                                                       </span>
                                                   </div>
                                               </a>
                                           </div>
                                           <div class="flex">
                                               Người dùng mới <a href="#">Trần Minh</a> đã đăng ký tài khoản<br />
                                               <small class="text-muted">1 giờ trước.</small>
                                           </div>
                                       </div>
                                       <div class="dropdown-item d-flex">
                                           <div class="mr-3">
                                               <a href="#">
                                                   <div class="avatar avatar-xs" style="width: 32px; height: 32px">
                                                       <span class="avatar-title rounded-circle">JD</span>
                                                   </div>
                                               </a>
                                           </div>
                                           <div class="flex">
                                               <a href="#">Mẫn Nhi</a>
                                               <small class="text-muted">nhắn bạn:</small><br />
                                               <div>
                                                   Chào mọi người, vui lòng lưu ý cuộc hẹn lúc 3 giờ chiều
                                               </div>
                                               <small class="text-muted">2 phút trước đây</small>
                                           </div>
                                       </div>

                                       <div class="dropdown-item d-flex">
                                           <div class="mr-3">
                                               <div class="avatar avatar-sm" style="width: 32px; height: 32px">
                                                   <img src="assets/images/256_daniel-gaffey-1060698-unsplash.jpg" alt="Avatar" class="avatar-img rounded-circle" />
                                               </div>
                                           </div>
                                           <div class="flex">
                                               <a href="">Tuấn</a> đã bình luận trong
                                               <a href="">Stack</a><br />
                                               <small class="text-muted">1 phút trước</small>
                                           </div>
                                       </div>
                                   </div>
                               </div>
                               <a href="javascript:void(0);" class="dropdown-item text-center navbar-notifications-menu__footer">
                                   View All
                               </a>
                           </div>
                       </li>
                   </ul>

                   <ul class="nav navbar-nav d-none d-sm-flex border-left navbar-border navbar-height align-items-center">
                       <li class="nav-item dropdown">
                           <a href="#account_menu" class="nav-link dropdown-toggle" data-toggle="dropdown" data-caret="false">
                               <span class="avatar avatar-sm">
                                   <span class="avatar-title rounded-circle bg-warning">
                                       Tuấn
                                   </span>
                               </span>
                           </a>
                           <div id="account_menu" class="dropdown-menu dropdown-menu-right">
                               <div class="dropdown-item-text dropdown-item-text--lh">
                                   <div><strong>Thanh Tuấn</strong></div>
                                   <div>@tuanphan</div>
                               </div>
                               <div class="dropdown-divider"></div>
                               <a class="dropdown-item active" href="<c:url value="#"/>">
                                   Dashboard
                               </a>
                               <a class="dropdown-item" href="<c:url value="<%=Path.USER_PROFILE %>"/>">
                                   My profile
                               </a>
                               <a class="dropdown-item" href="<c:url value="#"/>">
                                   Edit account
                               </a>
                               <div class="dropdown-divider"></div>
                               <a class="dropdown-item" href="<c:url value="#"/>">Logout</a>
                           </div>
                       </li>
                   </ul>
               </div>
           </div>
       </div>
   </div>

   <!-- // END Header -->

<div class="mdk-drawer js-mdk-drawer" id="default-drawer" data-align="start">
    <div class="mdk-drawer__content">
        <div class="sidebar sidebar-light sidebar-left" data-perfect-scrollbar>
            <div class="sidebar-heading sidebar-m-t">Menu</div>
            <ul class="sidebar-menu">
                <li class="sidebar-menu-item active">
                    <a class="sidebar-menu-button" href="#">
                        <i class="sidebar-menu-icon sidebar-menu-icon--left material-icons">view_compact</i>
                        <span class="sidebar-menu-text">Dashboard</span>
                    </a>
                </li>

                <li class="sidebar-menu-item">
                    <a class="sidebar-menu-button" href="#">
                        <i class="sidebar-menu-icon sidebar-menu-icon--left material-icons">business_center</i>
                        <span class="sidebar-menu-text">Project</span>
                    </a>
                </li>

                <li class="sidebar-menu-item">
                    <a class="sidebar-menu-button" href="#">
                        <i class="sidebar-menu-icon sidebar-menu-icon--left material-icons">people</i>
                        <span class="sidebar-menu-text">User</span>
                    </a>
                </li>
                <li class="sidebar-menu-item">
                    <a class="sidebar-menu-button" href="#">
                        <i class="sidebar-menu-icon sidebar-menu-icon--left material-icons">report</i>
                        <span class="sidebar-menu-text">Task</span>
                    </a>
                </li>
            </ul>

            <div class="sidebar-p-a sidebar-b-y">
                <div class="d-flex align-items-top mb-2">
                    <div class="sidebar-heading m-0 p-0 flex text-body js-text-body">
                        Progress
                    </div>
                    <div class="font-weight-bold text-success">60%</div>
                </div>
                <div class="progress">
                    <div class="progress-bar bg-success" role="progressbar" style="width: 60%" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
            </div>
        </div>
    </div>
</div>