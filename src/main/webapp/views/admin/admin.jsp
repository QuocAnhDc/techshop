<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>


<div class="page-container">

    <div class="page-head">
        <div class="container">
            <c:if test="${countOrder != 0}">
                <div class="alert alert-warning text-center">
                    <c:out value="Bạn có ${countOrder} đơn hàng chưa xác nhận! Vui lòng vào xác nhận"></c:out>
                </div>
            </c:if>
            <c:if test="${countCart != 0}">
                <div class="alert alert-warning text-center">
                    <c:out value="Bạn có ${countCart} giỏ hàng quá 30 ngày  chưa xóa ! Vui lòng xóa dọn dẹp"></c:out>
                </div>
            </c:if>



            <div class="page-title">
                <h1>Dashboard <small>statistics & reports</small></h1>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-6">
                        <a class="btn green" href="<c:url value="/admin/cart/delete" />"> Xóa các giỏ hàng đã quá 30 ngày</a>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-6">
                        <label for="year">Choose a year:</label>
                        <form action="<c:url value="/admin"/>" method="GET">
                        <select name="year" id="year" onchange="this.form.submit()">
                            <c:forEach var="year" items="${years}">
                                <c:if test="${pojo.year == year}">
                                    <option  selected value="${year}" >${year}</option>
                                </c:if>
                                <c:if  test="${pojo.year != year}" >
                                    <option value="${year}">${year}</option>
                                </c:if>

                            </c:forEach>
                        </select>
                        </form>

                    </div>

                </div>

                <div>
                    <canvas id="bar-chart" width="800" height="450"></canvas>
                </div>
                <div>
                    <input type="hidden" name="January"    id="January" value="${January}"/>
                    <input type="hidden" name="February"   id="February" value="${February}"/>
                    <input type="hidden" name="March"      id="March" value="${March}"/>
                    <input type="hidden" name="April"      id="April" value="${April}"/>
                    <input type="hidden" name="May"        id="May"  value="${May}"/>
                    <input type="hidden" name="June"       id="June"  value="${June}"/>
                    <input type="hidden" name="July"       id="July"  value="${July}"/>
                    <input type="hidden" name="August"     id="August"  value="${August}"/>
                    <input type="hidden" name="September"  id="September"  value="${September}"/>
                    <input type="hidden" name="October"    id="October"  value="${October}"/>
                    <input type="hidden" name="November"   id="November" value="${November}"/>
                    <input type="hidden" name="December"   id="December" value="${December}"/>
                </div>
            </div>
            <script>
                var data = new Array();
                data.push(document.getElementById("January").value);
                data.push(document.getElementById("February").value);
                data.push(document.getElementById("March").value);
                data.push(document.getElementById("April").value);
                data.push(document.getElementById("May").value);
                data.push(document.getElementById("June").value);
                data.push(document.getElementById("July").value);
                data.push(document.getElementById("August").value);
                data.push(document.getElementById("September").value);
                data.push(document.getElementById("October").value);
                data.push(document.getElementById("November").value);
                data.push(document.getElementById("December").value);

                console.log(data);

                const labels = [
                    'January',
                    'February',
                    'March',
                    'April',
                    'May',
                    'June',
                    'July',
                    'August',
                    'September',
                    'October',
                    'November',
                    'December'
                ];

                new Chart(document.getElementById("bar-chart"), {
                    type: 'bar',
                    data: {
                        labels: labels,
                        datasets: [
                            {
                                label: "Income (millions VND)",
                                backgroundColor: ["#3e95cd"],
                                data: data
                            }
                        ]
                    }
                });


            </script>
        </div>
    </div>
</div>
