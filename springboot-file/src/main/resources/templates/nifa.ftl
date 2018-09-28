
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <script type="text/javascript" src="/js/jquery.js"></script>
</head>



<body>
    <div>
        <label for="reportDate">
            <input type="date" id="reportDate" name="reportDate"/>
        </label>
        <button id="btn" name="btn" class="btn" onclick="generateDatas()">生成数据</button>
        <button id="btn" name="btn" class="btn" onclick="generateFiles()">生成文件</button>
        <button id="btn" name="btn" class="btn" onclick="postDebtZipFiles()">发送债权文件</button>
        <button id="btn" name="btn" class="btn" onclick="postTransZipFiles()">发送债转文件</button>
        <button id="btn" name="btn" class="btn" onclick="downloandDebt()">下载债权反馈文件</button>
        <button id="btn" name="btn" class="btn" onclick="downloandTrans()">下载债转反馈文件</button>
    </div>
</body>
<script type="text/javascript">
    // var reportDate = $("#reportDate").val();

        function generateDatas() {
            var reportDate = $("#reportDate").val();
            alert("生成数据");
            alert(reportDate);
            $.ajax({
                url: "/back/nifa/insertIntoTables?reportDate="+reportDate,
                type: "post",
                // data:{"reportDate":JSON.stringify(reportDate)},
                // dataType: "json",
                success: function (data) {
                    if (data.success) {
                        alert("操作成功!");
                    }else{
                        alert("操作失败"+data.message);
                    }
                }
            });
        }

        /**
         * 发送债权压缩文件
         * @param reportDate
         */
        function postDebtZipFiles() {
            var reportDate = $("#reportDate").val();
            alert(reportDate);

            $.ajax({
                url: "/back/nifa/debt/upload?reportDate="+reportDate,
                // data:{"reportDate":reportDate},
                // dataType: "json",
                type:"post",
                success: function (data) {
                    if (data.success) {
                        alert("发送债权文件操作成功!");
                    }else{
                        alert("发送债权文件操作失败");
                    }
                }
            })
        }
        /**
         * 发送债转文件
         */
        function postTransZipFiles() {
            var reportDate = $("#reportDate").val();
            alert(reportDate);

            $.ajax({
                url: "/back/nifa/trans/upload?reportDate="+reportDate,
                // data:{"reportDate":reportDate},
                // dataType: "json",
                type:"post",
                success: function (data) {
                    if (data.success) {
                        alert("发送债转文件操作成功!");
                    }else{
                        alert("发送债转文件操作失败");
                    }
                }
            })
        }
        /**
         * 生成文件 及压缩包
         * @param reportDate
         */
        function generateFiles() {
            var reportDate = $("#reportDate").val();
            alert(reportDate);
            $.ajax({
                url: "/nifa/generate?reportDate="+reportDate,
                // data:{"reportDate":reportDate},
                // dataType: "json",
                type:"post",
                success: function (data) {
                    if (data.success) {
                        alert("生成文件操作成功!");
                    }else{
                        alert("生成文件操作失败");
                    }
                }
            })
        }


    /**
     * 下载债权反馈文件
     */
    function downloandDebt() {
        var reportDate = $("#reportDate").val();
        $.ajax({
            url: "/back/nifa/download/debt?reportDate="+reportDate,
            // data:{"reportDate":reportDate},
            // dataType: "json",
            type:"post",
            success: function (data) {
                if (data.success) {
                    alert("下载文件成功");
                }else{
                    alert("下载文件失败");
                }
            }
        })
    }
    function downloandTrans() {
        var reportDate = $("#reportDate").val();
        $.ajax({
            url: "/back/nifa/download/trans?reportDate="+reportDate,
            // data:{"reportDate":reportDate},
            // dataType: "json",
            type:"post",
            success: function (data) {
                if (data.success) {
                    alert("下载文件成功");
                }else{
                    alert("下载文件失败");
                }
            }
        })
    }


</script>