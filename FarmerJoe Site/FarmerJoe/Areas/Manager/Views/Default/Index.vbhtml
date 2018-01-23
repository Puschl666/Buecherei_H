@Code
    ViewData("Title") = "Admin Dashboard"
    Layout = "~/Areas/Manager/Views/Layout/Default.vbhtml"
End Code

<!--BLOCK SECTION -->
<div class="row">
    <div class="col-lg-12">
        <div style="text-align: center;">

            <a class="quick-btn" href="#">
                <i class="fa fa-check-square-o fa-2x"></i>
                <span> Products</span>
                <span class="label label-danger">2</span>
            </a>

            <a class="quick-btn" href="#">
                <i class="fa fa-envelope fa-2x"></i>
                <span>Messages</span>
                <span class="label label-success">456</span>
            </a>
            <a class="quick-btn" href="#">
                <i class="fa fa-signal fa-2x"></i>
                <span>Profit</span>
                <span class="label label-warning">+25</span>
            </a>
            <a class="quick-btn" href="#">
                <i class="fa fa-external-link fa-2x"></i>
                <span>value</span>
                <span class="label btn-metis-2">3.14159265</span>
            </a>
            <a class="quick-btn" href="#">
                <i class="fa fa-lemon-o fa-2x"></i>
                <span>tasks</span>
                <span class="label btn-metis-4">107</span>
            </a>
            <a class="quick-btn" href="#">
                <i class="fa fa-bolt fa-2x"></i>
                <span>Tickets</span>
                <span class="label label-default">20</span>
            </a>



        </div>

    </div>

</div>
<!--END BLOCK SECTION -->
<hr />
<!-- CHART & CHAT  SECTION -->
<div class="row">
    <div class="col-lg-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                Real Time Traffic
            </div>


            <div class="demo-container">
                <div id="placeholderRT" class="demo-placeholder"></div>
            </div>

        </div>

    </div>


    <div class="col-lg-4">

        <div class="chat-panel panel panel-primary">
            <div class="panel-heading">
                <i class="fa fa-comments"></i>
                Chat
                <div class="btn-group pull-right">
                    <button type="button" data-toggle="dropdown">
                        <i class="fa fa-chevron-down"></i>
                    </button>
                    <ul class="dropdown-menu slidedown">
                        <li>
                            <a href="#">
                                <i class="fa fa-refresh"></i> Refresh
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-comment"></i> Available
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-time"></i> Busy
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="fa fa-tint"></i> Away
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <i class="fa fa-signout"></i> Sign Out
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="panel-body">
                <ul class="chat">
                    <li class="left clearfix">
                        <span class="chat-img pull-left">
                            <img src="assets/img/1.png" alt="User Avatar" class="img-circle" />
                        </span>
                        <div class="chat-body clearfix">
                            <div class="header">
                                <strong class="primary-font"> Jack Sparrow </strong>
                                <small class="pull-right text-muted">
                                    <i class="fa fa-time"></i> 12 mins ago
                                </small>
                            </div>
                            <br />
                            <p>
                                Lorem ipsum dolor sit amet, bibendum ornare dolor, quis ullamcorper ligula sodales.
                            </p>
                        </div>
                    </li>
                    <li class="right clearfix">
                        <span class="chat-img pull-right">
                            <img src="assets/img/2.png" alt="User Avatar" class="img-circle" />
                        </span>
                        <div class="chat-body clearfix">
                            <div class="header">
                                <small class=" text-muted">
                                    <i class="fa fa-time"></i> 13 mins ago
                                </small>
                                <strong class="pull-right primary-font"> Jhony Deen</strong>
                            </div>
                            <br />
                            <p>
                                Lorem ipsum dolor sit amet, consectetur a dolor, quis ullamcorper ligula sodales.
                            </p>
                        </div>
                    </li>
                    <li class="left clearfix">
                        <span class="chat-img pull-left">
                            <img src="assets/img/3.png" alt="User Avatar" class="img-circle" />
                        </span>
                        <div class="chat-body clearfix">
                            <div class="header">
                                <strong class="primary-font"> Jack Sparrow </strong>
                                <small class="pull-right text-muted">
                                    <i class="fa fa-time"></i> 12 mins ago
                                </small>
                            </div>
                            <br />
                            <p>
                                Lorem ipsum dolor sit amet, bibendum ornare dolor, quis ullamcorper ligula sodales.
                            </p>
                        </div>
                    </li>
                    <li class="right clearfix">
                        <span class="chat-img pull-right">
                            <img src="assets/img/4.png" alt="User Avatar" class="img-circle" />
                        </span>
                        <div class="chat-body clearfix">
                            <div class="header">
                                <small class=" text-muted">
                                    <i class="fa fa-time"></i> 13 mins ago
                                </small>
                                <strong class="pull-right primary-font"> Jhony Deen</strong>
                            </div>
                            <br />
                            <p>
                                Lorem ipsum dolor sit amet, consectetur a dolor, quis ullamcorper ligula sodales.
                            </p>
                        </div>
                    </li>
                </ul>
            </div>

            <div class="panel-footer">
                <div class="input-group">
                    <input id="Text1" type="text" class="form-control input-sm" placeholder="Type your message here..." />
                    <span class="input-group-btn">
                        <button class="btn btn-warning btn-sm" id="Button1">
                            Send
                        </button>
                    </span>
                </div>
            </div>

        </div>


    </div>
</div>
<!--END CHAT & CHAT SECTION -->
<!-- COMMENT AND NOTIFICATION  SECTION -->
<div class="row">
    <div class="col-lg-7">

        <div class="chat-panel panel panel-success">
            <div class="panel-heading">
                <i class="fa fa-comments"></i>
                New Comments

            </div>

            <div class="panel-body">
                <ul class="chat">
                    <li class="left clearfix">
                        <span class="chat-img pull-left">
                            <img src="assets/img/1.png" alt="User Avatar" class="img-circle" />
                        </span>
                        <div class="chat-body clearfix">
                            <div class="header">
                                <strong class="primary-font "> Jack Sparrow </strong>
                                <small class="pull-right text-muted label label-danger">
                                    <i class="fa fa-time"></i> 12 mins ago
                                </small>
                            </div>
                            <br />
                            <p>
                                Lorem ipsum dolor sit amet, bibendum ornare dolor, quis ullamcorper ligula sodales.
                            </p>
                        </div>
                    </li>
                    <li class="right clearfix">
                        <span class="chat-img pull-right">
                            <img src="assets/img/2.png" alt="User Avatar" class="img-circle" />
                        </span>
                        <div class="chat-body clearfix">
                            <div class="header">
                                <small class=" text-muted label label-info">
                                    <i class="fa fa-time"></i> 13 mins ago
                                </small>
                                <strong class="pull-right primary-font"> Jhony Deen</strong>
                            </div>
                            <br />
                            <p>
                                Lorem ipsum dolor sit amet, consectetur a dolor, quis ullamcorper ligula sodales.
                            </p>
                        </div>
                    </li>
                    <li class="left clearfix">
                        <span class="chat-img pull-left">
                            <img src="assets/img/3.png" alt="User Avatar" class="img-circle" />
                        </span>
                        <div class="chat-body clearfix">
                            <div class="header">
                                <strong class="primary-font"> Jack Sparrow </strong>
                                <small class="pull-right text-muted label label-warning">
                                    <i class="fa fa-time"></i> 12 mins ago
                                </small>
                            </div>
                            <br />
                            <p>
                                Lorem ipsum dolor sit amet, bibendum ornare dolor, quis ullamcorper ligula sodales.
                            </p>
                        </div>
                    </li>
                    <li class="right clearfix">
                        <span class="chat-img pull-right">
                            <img src="assets/img/4.png" alt="User Avatar" class="img-circle" />
                        </span>
                        <div class="chat-body clearfix">
                            <div class="header">
                                <small class=" text-muted label label-primary">
                                    <i class="fa fa-time"></i> 13 mins ago
                                </small>
                                <strong class="pull-right primary-font"> Jhony Deen</strong>
                            </div>
                            <br />
                            <p>
                                Lorem ipsum dolor sit amet, consectetur a dolor, quis ullamcorper ligula sodales.
                            </p>
                        </div>
                    </li>
                </ul>
            </div>

            <div class="panel-footer">
                <div class="input-group">
                    <input id="btn-input" type="text" class="form-control input-sm" placeholder="Type your comment here..." />
                    <span class="input-group-btn">
                        <button class="btn btn-success btn-sm" id="btn-chat">
                            Send
                        </button>
                    </span>
                </div>
            </div>

        </div>


    </div>
    <div class="col-lg-5">

        <div class="panel panel-danger">
            <div class="panel-heading">
                <i class="fa fa-bell"></i> Notifications Alerts Panel
            </div>

            <div class="panel-body">
                <div class="list-group">
                    <a href="#" class="list-group-item">
                        <i class="fa fa-comment"></i> New Comment
                        <span class="pull-right text-muted small">
                            <em> 4 minutes ago</em>
                        </span>
                    </a>
                    <a href="#" class="list-group-item">
                        <i class="fa fa-twitter"></i> 3 New Followers
                        <span class="pull-right text-muted small">
                            <em> 12 minutes ago</em>
                        </span>
                    </a>
                    <a href="#" class="list-group-item">
                        <i class="fa fa-envelope"></i> Message Sent
                        <span class="pull-right text-muted small">
                            <em> 27 minutes ago</em>
                        </span>
                    </a>
                    <a href="#" class="list-group-item">
                        <i class="fa fa-tasks"></i> New Task
                        <span class="pull-right text-muted small">
                            <em>43 minutes ago</em>
                        </span>
                    </a>
                    <a href="#" class="list-group-item">
                        <i class="fa fa-upload"></i> Server Rebooted
                        <span class="pull-right text-muted small">
                            <em>11:32 AM</em>
                        </span>
                    </a>
                    <a href="#" class="list-group-item">
                        <i class="fa fa-warning"></i> Server Crashed!
                        <span class="pull-right text-muted small">
                            <em>11:13 AM</em>
                        </span>
                    </a>

                    <a href="#" class="list-group-item">
                        <i class="fa fa-check"></i> New Order Placed
                        <span class="pull-right text-muted small">
                            <em>9:49 AM</em>
                        </span>
                    </a>
                    <a href="#" class="list-group-item">
                        <i class="fa fa-money"></i> Payment Received
                        <span class="pull-right text-muted small">
                            <em>Yesterday</em>
                        </span>
                    </a>
                </div>

                <a href="#" class="btn btn-default btn-block btn-primary">View All Alerts</a>
            </div>

        </div>



    </div>
</div>
<!-- END COMMENT AND NOTIFICATION  SECTION -->
<!--  STACKING CHART  SECTION   -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Sales   Stacking
            </div>

            <div class="panel-body">

                <div class="demo-container">
                    <div id="placeholderStack" class="demo-placeholder"></div>
                </div>
                <p class="stackControls">
                    <button class="btn btn-primary">With stacking</button>
                    <button class="btn btn-primary">Without stacking</button>
                </p>

                <p class="graphControls">
                    <button class="btn btn-primary">Bars</button>
                    <button class="btn btn-primary">Lines</button>
                    <button class="btn btn-primary">Lines with steps</button>
                </p>
            </div>

        </div>
    </div>

</div>
<!--END STACKING CHART SCETION  -->
<!--TABLE, PANEL, ACCORDION AND MODAL  -->
<div class="row">
    <div class="col-lg-6">
        <div class="box">
            <header>
                <h5>Simple Table</h5>
                <div class="toolbar">
                    <div class="btn-group">
                        <a href="#sortableTable" data-toggle="collapse" class="btn btn-default btn-sm accordion-toggle minimize-box">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
            </header>
            <div id="sortableTable" class="body collapse in">
                <table class="table table-bordered sortableTable responsive-table">
                    <thead>
                        <tr>
                            <th>#<i class="fa fa-sort"></i><i class="fa fa-sort-down"></i> <i class="fa fa-sort-up"></i></th>
                            <th>First Name<i class="fa fa-sort"></i><i class="fa fa-sort-down"></i> <i class="fa fa-sort-up"></i></th>
                            <th>Last Name<i class="fa fa-sort"></i><i class="fa fa-sort-down"></i> <i class="fa fa-sort-up"></i></th>
                            <th>Score<i class="fa fa-sort"></i><i class="fa fa-sort-down"></i> <i class="fa fa-sort-up"></i></th>
                        </tr>
                    </thead>
                    <tbody>


                        <tr>
                            <td>1</td>
                            <td>Jill</td>
                            <td>Smith</td>
                            <td>50</td>
                        </tr>

                        <tr>
                            <td>2</td>
                            <td>Eve</td>
                            <td>Jackson</td>
                            <td>94</td>
                        </tr>

                        <tr>
                            <td>3</td>
                            <td>John</td>
                            <td>Doe</td>
                            <td>80</td>
                        </tr>

                        <tr>
                            <td>4</td>
                            <td>Adam</td>
                            <td>Johnson</td>
                            <td>67</td>
                        </tr>


                    </tbody>
                </table>
            </div>
        </div>
        <div class="panel panel-primary">
            <div class="panel-heading ">
                Collapsible Accordion Panel Group
            </div>
            <div class="panel-body">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Collapsible Group Item #1</a>
                            </h4>
                        </div>
                        <div id="collapseOne" class="panel-collapse collapse in">
                            <div class="panel-body">
                                Lorem ipsum dolor sit amet, luaute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Collapsible Group Item #2</a>
                            </h4>
                        </div>
                        <div id="collapseTwo" class="panel-collapse collapse">
                            <div class="panel-body">
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">Collapsible Group Item #3</a>
                            </h4>
                        </div>
                        <div id="collapseThree" class="panel-collapse collapse">
                            <div class="panel-body">
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-6">
        <div class="panel panel-primary">
            <div class="panel-heading">
                Primary Panel
            </div>
            <div class="panel-body">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum tincidunt est vitae ultrices accumsan. Aliquam ornare lacus adipiscing, posuere lectus et, fringilla augue.</p>
            </div>
            <div class="panel-footer">
                Panel Footer
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                Context Classes
            </div>
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Username</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="success">
                                <td>1</td>
                                <td>Mark</td>
                                <td>Otto</td>
                                <td>mdo</td>
                            </tr>
                            <tr class="info">
                                <td>2</td>
                                <td>Jacob</td>
                                <td>Thornton</td>
                                <td>fat</td>
                            </tr>
                            <tr class="warning">
                                <td>3</td>
                                <td>Larry</td>
                                <td>the Bird</td>
                                <td>twitter</td>
                            </tr>
                            <tr class="danger">
                                <td>4</td>
                                <td>John</td>
                                <td>Smith</td>
                                <td>jsmith</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                Modal Example
            </div>
            <div class="panel-body">
                <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                    Launch Demo Modal
                </button>
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                            </div>
                            <div class="modal-body">
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Save changes</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--TABLE, PANEL, ACCORDION AND MODAL  -->

<script>
    //REAL TIME GRAPH FUNCTION 
    $(function () {

        // We use an inline data source in the example, usually data would
        // be fetched from a server

        var data = [],
            totalPoints = 300;

        function getRandomData() {

            if (data.length > 0)
                data = data.slice(1);

            // Do a random walk

            while (data.length < totalPoints) {

                var prev = data.length > 0 ? data[data.length - 1] : 50,
                    y = prev + Math.random() * 10 - 5;

                if (y < 0) {
                    y = 0;
                } else if (y > 100) {
                    y = 100;
                }

                data.push(y);
            }

            // Zip the generated y values with the x values

            var res = [];
            for (var i = 0; i < data.length; ++i) {
                res.push([i, data[i]])
            }

            return res;
        }

        // Set up the control widget

        var updateInterval = 30;
        $("#updateInterval").val(updateInterval).change(function () {
            var v = $(this).val();
            if (v && !isNaN(+v)) {
                updateInterval = +v;
                if (updateInterval < 1) {
                    updateInterval = 1;
                } else if (updateInterval > 2000) {
                    updateInterval = 2000;
                }
                $(this).val("" + updateInterval);
            }
        });

        var plot = $.plot("#placeholderRT", [getRandomData()], {
            series: {
                shadowSize: 0	// Drawing is faster without shadows
            },
            yaxis: {
                min: 0,
                max: 100
            },
            xaxis: {
                show: false
            }
        });

        function update() {

            plot.setData([getRandomData()]);

            // Since the axes don't change, we don't need to call plot.setupGrid()

            plot.draw();
            setTimeout(update, updateInterval);
        }

        update();

    });
    //END REAL TIME GRAPH FUNCTION 

    //SALES STACKING FUNCTION
    $(function () {

        var d1 = [];
        for (var i = 0; i <= 10; i += 1) {
            d1.push([i, parseInt(Math.random() * 30)]);
        }

        var d2 = [];
        for (var i = 0; i <= 10; i += 1) {
            d2.push([i, parseInt(Math.random() * 30)]);
        }

        var d3 = [];
        for (var i = 0; i <= 10; i += 1) {
            d3.push([i, parseInt(Math.random() * 30)]);
        }

        var stack = 0,
            bars = true,
            lines = false,
            steps = false;

        function plotWithOptions() {
            $.plot("#placeholderStack", [d1, d2, d3], {
                series: {
                    stack: stack,
                    lines: {
                        show: lines,
                        fill: true,
                        steps: steps
                    },
                    bars: {
                        show: bars,
                        barWidth: 0.6
                    }
                }
            });
        }

        plotWithOptions();

        $(".stackControls button").click(function (e) {
            e.preventDefault();
            stack = $(this).text() == "With stacking" ? true : null;
            plotWithOptions();
        });

        $(".graphControls button").click(function (e) {
            e.preventDefault();
            bars = $(this).text().indexOf("Bars") != -1;
            lines = $(this).text().indexOf("Lines") != -1;
            steps = $(this).text().indexOf("steps") != -1;
            plotWithOptions();
        });

        // Add the Flot version string to the footer

    });
    // END SALES STACKING FUNCTION


    // tooltip demo
    $('.tooltip-demo').tooltip({
        selector: "[data-toggle=tooltip]",
        container: "body"
    })

    // popover demo
    $("[data-toggle=popover]")
        .popover()

    //END TOOLTIP AND HOVERS
</script>