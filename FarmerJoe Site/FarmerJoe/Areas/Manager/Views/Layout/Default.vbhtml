<!DOCTYPE html>
<html lang="de">
<!-- BEGIN HEAD -->
<head>
    <meta charset="UTF-8" />
    <title>@ViewData("Title") | FarmerJoe-Manager</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="description" />
    <meta content="" name="author" />
    @Styles.Render("~/css/manager")
    @Scripts.Render("~/javascript/manager")
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="padTop53 ">
    <!-- MAIN WRAPPER -->
    <div id="wrap">
        <!-- HEADER SECTION -->
        <div id="top">
            <nav class="navbar navbar-inverse navbar-fixed-top " style="padding-top: 10px;">
                <a data-original-title="Show/Hide Menu" data-placement="bottom" data-tooltip="tooltip" class="accordion-toggle btn btn-primary btn-sm visible-xs" data-toggle="collapse" href="#menu" id="menu-toggle">
                    <i class="fa fa-align-justify"></i>
                </a>
                <!-- LOGO SECTION -->
                <header class="navbar-header">
                    <a href="/manager" class="navbar-brand">
                        <img src="/Images/logo.png" alt="" />
                    </a>
                </header>
                <!-- END LOGO SECTION -->
                <ul class="nav navbar-top-links navbar-right">
                    @*<!-- MESSAGES SECTION -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <span class="label label-success">2</span>    <i class="fa fa-envelope-o"></i>&nbsp; <i class="fa fa-chevron-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-messages">
                            <li>
                                <a href="#">
                                    <div>
                                        <strong>John Smith</strong>
                                        <span class="pull-right text-muted">
                                            <em>Today</em>
                                        </span>
                                    </div>
                                    <div>
                                        Lorem ipsum dolor sit amet, consectetur adipiscing.
                                        <br />
                                        <span class="label label-primary">Important</span>

                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <strong>Raphel Jonson</strong>
                                        <span class="pull-right text-muted">
                                            <em>Yesterday</em>
                                        </span>
                                    </div>
                                    <div>
                                        Lorem ipsum dolor sit amet, consectetur adipiscing.
                                        <br />
                                        <span class="label label-success"> Moderate </span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <strong>Chi Ley Suk</strong>
                                        <span class="pull-right text-muted">
                                            <em>26 Jan 2014</em>
                                        </span>
                                    </div>
                                    <div>
                                        Lorem ipsum dolor sit amet, consectetur adipiscing.
                                        <br />
                                        <span class="label label-danger"> Low </span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a class="text-center" href="#">
                                    <strong>Read All Messages</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <!--END MESSAGES SECTION -->
                    <!--TASK SECTION -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <span class="label label-danger">5</span>   <i class="fa fa-tasks"></i>&nbsp; <i class="fa fa-chevron-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-tasks">
                            <li>
                                <a href="#">
                                    <div>
                                        <p>
                                            <strong> Profile </strong>
                                            <span class="pull-right text-muted">40% Complete</span>
                                        </p>
                                        <div class="progress progress-striped active">
                                            <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                                <span class="sr-only">40% Complete (success)</span>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <p>
                                            <strong> Pending Tasks </strong>
                                            <span class="pull-right text-muted">20% Complete</span>
                                        </p>
                                        <div class="progress progress-striped active">
                                            <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                                <span class="sr-only">20% Complete</span>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <p>
                                            <strong> Work Completed </strong>
                                            <span class="pull-right text-muted">60% Complete</span>
                                        </p>
                                        <div class="progress progress-striped active">
                                            <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                                <span class="sr-only">60% Complete (warning)</span>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <p>
                                            <strong> Summary </strong>
                                            <span class="pull-right text-muted">80% Complete</span>
                                        </p>
                                        <div class="progress progress-striped active">
                                            <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                                <span class="sr-only">80% Complete (danger)</span>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a class="text-center" href="#">
                                    <strong>See All Tasks</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <!--END TASK SECTION -->
                    <!--ALERTS SECTION -->
                    <li class="chat-panel dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <span class="label label-info">8</span>   <i class="fa fa-comments"></i>&nbsp; <i class="fa fa-chevron-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">

                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-comment"></i> New Comment
                                        <span class="pull-right text-muted small"> 4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-twitter info"></i> 3 New Follower
                                        <span class="pull-right text-muted small"> 9 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-envelope"></i> Message Sent
                                        <span class="pull-right text-muted small"> 20 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-tasks"></i> New Task
                                        <span class="pull-right text-muted small"> 1 Hour ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-upload"></i> Server Rebooted
                                        <span class="pull-right text-muted small"> 2 Hour ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a class="text-center" href="#">
                                    <strong>See All Alerts</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <!-- END ALERTS SECTION -->*@
                    <!--ADMIN SETTINGS SECTIONS -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user "></i>&nbsp; <i class="fa fa-chevron-down "></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li>
                                <a href="#"><i class="fa fa-user"></i> User Profile </a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-gear"></i> Settings </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="/admin/logout"><i class="fa fa-sign-out"></i> Logout </a>
                            </li>
                        </ul>
                    </li>
                    <!--END ADMIN SETTINGS -->
                </ul>
            </nav>
        </div>
        <!-- END HEADER SECTION -->
        <!-- MENU SECTION -->
        <div id="left">
            @*<div class="media user-media well-small">
                <a class="user-link" href="#">
                    <img class="media-object img-thumbnail user-img" alt="User Picture" src="assets/img/user.gif" />
                </a>
                <br />
                <div class="media-body">
                    <h5 class="media-heading"> Joe Romlin</h5>
                    <ul class="list-unstyled user-info">

                        <li>
                            <a class="btn btn-success btn-xs btn-circle" style="width: 10px;height: 12px;"></a> Online

                        </li>

                    </ul>
                </div>
                <br />
            </div>*@
            <ul id="menu" class="collapse">
                <li class="panel active">
                    <a href="/manager">
                        <i class="fa fa-table"></i> Dashboard
                    </a>
                </li>
                <li class="panel">
                    <a href="#" data-parent="#menu" data-toggle="collapse" class="accordion-toggle" data-target="#component-uma">
                        <i class="fa fa-user"></i> UMA
                        <span class="pull-right">
                            <i class="fa fa-angle-left"></i>
                        </span>
                        &nbsp; <span class="label label-default">1</span>&nbsp;
                    </a>
                    <ul class="collapse" id="component-uma">
                        <li class=""><a href="/manager/uma/accordion"><i class="fa fa-angle-right"></i> Accordion </a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!--END MENU SECTION -->

        <!--PAGE CONTENT -->
        <div id="content">
            <div class="inner" style="min-height: 700px;">
                <div class="row">
                    <div class="col-lg-12">
                        <h1>@ViewData("Title")</h1>
                    </div>
                </div>
                <hr />
                @RenderBody()
            </div>
        </div>
        <!--END PAGE CONTENT -->

        <!-- RIGHT STRIP  SECTION -->
        <div id="right">
            <div class="well well-small">
                <ul class="list-unstyled">
                    <li>Visitor &nbsp; : <span>23,000</span></li>
                    <li>Users &nbsp; : <span>53,000</span></li>
                    <li>Registrations &nbsp; : <span>3,000</span></li>
                </ul>
            </div>
            @*<div class="well well-small">
                <button class="btn btn-block"> Help </button>
                <button class="btn btn-primary btn-block"> Tickets</button>
                <button class="btn btn-info btn-block"> New </button>
                <button class="btn btn-success btn-block"> Users </button>
                <button class="btn btn-danger btn-block"> Profit </button>
                <button class="btn btn-warning btn-block"> Sales </button>
                <button class="btn btn-inverse btn-block"> Stock </button>
            </div>
            <div class="well well-small">
                <span>Profit</span><span class="pull-right"><small>20%</small></span>

                <div class="progress mini">
                    <div class="progress-bar progress-bar-info" style="width: 20%"></div>
                </div>
                <span>Sales</span><span class="pull-right"><small>40%</small></span>

                <div class="progress mini">
                    <div class="progress-bar progress-bar-success" style="width: 40%"></div>
                </div>
                <span>Pending</span><span class="pull-right"><small>60%</small></span>

                <div class="progress mini">
                    <div class="progress-bar progress-bar-warning" style="width: 60%"></div>
                </div>
                <span>Summary</span><span class="pull-right"><small>80%</small></span>

                <div class="progress mini">
                    <div class="progress-bar progress-bar-danger" style="width: 80%"></div>
                </div>
            </div>*@
        </div>
        <!-- END RIGHT STRIP  SECTION -->
    </div>
    <!--END MAIN WRAPPER -->

    <!-- FOOTER -->
    <div id="footer">
        <p>&copy;  Daniel Dennerlein &nbsp;2017 &nbsp;</p>
    </div>
    <!--END FOOTER -->
</body>
<!-- END BODY -->
</html>
