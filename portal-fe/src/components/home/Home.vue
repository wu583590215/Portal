<template>
    <div style="height: 100%">
        <a-row :gutter="20" style="display: flex;height: 45%">
            <a-col :span="6" >
                <a-card  :bordered="false" class="box-card" >
                    <div slot="title" class="clearfix">
                        <span>系统导航</span>
                    </div>

                    <a-card-grid style="width: 32%;text-align:center;margin-left: 2%">
                        <img src="../../assets/image/home/system_1.png" style="width: 35px;margin-left: 10px">
                        <div style="text-align: center">
                            <span>流程银行</span>
                        </div>
                    </a-card-grid>
                    <a-card-grid style="width: 32%;text-align:center">
                        <img src="../../assets/image/home/system_3.png" style="width: 35px;margin-left: 10px">
                        <div style="text-align: center">
                            <span>智能运营</span>
                        </div>
                    </a-card-grid>
                    <a-card-grid style="width: 32%;text-align:center">
                        <img src="../../assets/image/home/system_4.png" style="width: 35px;margin-left: 10px">
                        <div style="text-align: center">
                            <span>绩效管理</span>
                        </div>
                    </a-card-grid>
                    <a-card-grid style="width: 32%;text-align:center;margin-left: 2%">
                        <img src="../../assets/image/home/system_2.png" style="width: 35px;margin-left: 10px">
                        <div style="text-align: center">
                            <span>报送平台</span>
                        </div>
                    </a-card-grid>




                  <!--  <a-col :span="8">
                        <a-card :body-style="{ padding: '10px' }"  style="cursor: pointer;">
                            <img src="../../assets/image/home/system_1.png" class="image" width="35px"
                                 style="margin-left: 30px">
                            <div style="text-align: center">
                                <span>流程银行</span>
                            </div>
                        </a-card>
                    </a-col>

                    <a-col :span="8">
                        <a-card :body-style="{ padding: '10px' }" shadow="hover" style="cursor: pointer;">
                            <img src="../../assets/image/home/system_3.png" class="image" width="35px"
                                 style="margin-left: 30px">
                            <div style="text-align: center">
                                <span>智能运营</span>
                            </div>
                        </a-card>
                    </a-col>

                    <a-col :span="8">
                        <a-card :body-style="{ padding: '10px' }" shadow="hover" style="cursor: pointer;">
                            <img src="../../assets/image/home/system_4.png" class="image" width="35px"
                                 style="margin-left: 30px">
                            <div style="text-align: center">
                                <span>绩效管理</span>
                            </div>
                        </a-card>
                    </a-col>

                    <a-col :span="8" style="margin-top: 20px">
                        <a-card :body-style="{ padding: '10px' }" shadow="hover" style="cursor: pointer;">
                            <img src="../../assets/image/home/system_2.png" class="image" width="35px"
                                 style="margin-left: 30px">
                            <div style="text-align: center">
                                <span>报送平台</span>
                            </div>
                        </a-card>
                    </a-col>-->

                </a-card>
            </a-col>

            <a-col :span="10">
                <a-card  :bordered="false" class="box-card" >
                    <div slot="title" class="clearfix">
                        <span>代办任务</span>
                    </div>

                    <div>
                        <span style="color: #4977FC"><a-icon type="solution" />我的代办</span>
                        <span style="color: red;margin-left: 10px">(2)</span>
                    </div>

                    <div style="margin: 20px auto;width: 92%;">
                        <div style="color: rgba(102,102,102,1)">
                            <a-icon type="caret-right" style="color: #2192F5"/>
                            这是一个代办事项现在没有数据以后接入一些数据
                            <a-tag color="#f50" style="float: right;width: 80px;text-align: center;letter-spacing: 5px;">
                                超时
                            </a-tag>
                        </div>
                        <div style="font-weight:500;color:rgba(102,102,102,1);line-height:50px;margin-left: 20px">
                            2020-4-28 18:23:45
                        </div>
                    </div>

                    <div style="margin: 20px auto;width: 92%;">
                        <div style="color: rgba(102,102,102,1)">
                            <a-icon type="caret-right" style="color: #2192F5"/>
                            这是一个代办事项现在没有数据以后接入一些数据
                            <a-tag color="#f50" style="float: right;width: 80px;text-align: center;letter-spacing: 5px;">
                                超时
                            </a-tag>
                        </div>
                        <div style="font-weight:500;color:rgba(102,102,102,1);line-height:50px;margin-left: 20px">
                            2020-4-28 18:23:45
                        </div>
                    </div>

                </a-card>
            </a-col>

            <a-col :span="8" >
                <a-card  :bordered="false" class="box-card" >
                    <div slot="title" class="clearfix">
                        <span><a-icon type="calendar" />工作日历</span>
                    </div>

                    <div style="height: 400px;overflow: auto">
                        <test></test>
                    </div>
                </a-card>
            </a-col>
        </a-row>

        <a-row :gutter="20" style="display: flex;margin-top: 20px;padding-bottom: 20px">
            <a-col :span="8" >
                <a-card  :bordered="false" class="box-card" >
                    <div slot="title" class="clearfix">
                        <span>消息通知</span>
                    </div>

                    <div style="overflow: auto;height: 300px">
                        <div style="border-bottom: 1px solid rgba(233,233,233,1);margin-top: 5px">
                            <a-row class="row-bg">
                                <a-col :span="4">
                                        <img src="../../assets/image/home/message.png" style="width: 45px">
                                </a-col>
                                <a-col :span="18">
                                    <span style="font-family:PingFang SC;font-weight:600;color:rgba(51,51,51,1);">
                                        系统消息
                                        <span style="font-family:PingFang SC;font-weight:400;color:rgba(153,153,153,1);float: right">
                                            8:30</span>
                                    </span>

                                    <span style="display: block;font-size:16px;font-family:PingFang SC;font-weight:400;color:rgba(153,153,153,1);line-height: 35px">
                                        这是一条系统消息，现在还没有数据</span>
                                </a-col>
                            </a-row>
                        </div>

                        <div style="border-bottom: 1px solid rgba(233,233,233,1);margin-top: 30px">
                            <a-row class="row-bg">
                                <a-col :span="4">
                                    
                                        <img src="../../assets/image/home/message.png" style="width: 45px">
                                    
                                </a-col>
                                <a-col :span="18">
                                    <span style="font-family:PingFang SC;font-weight:600;color:rgba(51,51,51,1);">
                                        系统消息
                                        <span style="font-family:PingFang SC;font-weight:400;color:rgba(153,153,153,1);float: right">
                                            8:30</span>
                                    </span>

                                    <span style="display: block;font-size:16px;font-family:PingFang SC;font-weight:400;color:rgba(153,153,153,1);line-height: 35px">
                                        这是一条系统消息，现在还没有数据</span>
                                </a-col>
                            </a-row>
                        </div>

                        <div style="border-bottom: 1px solid rgba(233,233,233,1);margin-top: 30px">
                            <a-row class="row-bg">
                                <a-col :span="4">
                                    
                                        <img src="../../assets/image/home/message.png" style="width: 45px">
                                    
                                </a-col>
                                <a-col :span="18">
                                    <span style="font-family:PingFang SC;font-weight:600;color:rgba(51,51,51,1);">
                                        系统消息
                                        <span style="font-family:PingFang SC;font-weight:400;color:rgba(153,153,153,1);float: right">
                                            8:30</span>
                                    </span>

                                    <span style="display: block;font-size:16px;font-family:PingFang SC;font-weight:400;color:rgba(153,153,153,1);line-height: 35px">
                                        这是一条系统消息，现在还没有数据</span>
                                </a-col>
                            </a-row>
                        </div>

                    </div>

                </a-card>
            </a-col>
            <a-col :span="8" >
                <a-card  :bordered="false" class="box-card" >
                    <div slot="title" class="clearfix">
                        <span>个人绩效统计</span>
                    </div>

                    <div id="PerformanceCharts" style="height: 350px;width: 100%">

                    </div>

                </a-card>
            </a-col>
            <a-col :span="8" >
                <a-card  :bordered="false" class="box-card" >
                    <div slot="title" class="clearfix">
                        <span>个人业绩统计</span>
                    </div>

                    <div>
                        <a-row class="row-bg">
                            <a-col :span="2" :offset="1">
                                <img src="../../assets/image/home/icon_1.png" width="25px">
                            </a-col>
                            <a-col :span="6">
                                <span style="font-weight:400;color:rgba(153,153,153,1);">指标代号：</span>
                            </a-col>

                            <a-col :span="14">
                                <span>ASLKDJNDJ</span>
                            </a-col>

                        </a-row>


                        <a-row class="row-bg" style="margin-top: 30px">
                            <a-col :span="2" :offset="1">
                                <img src="../../assets/image/home/icon_2.png" width="25px">
                            </a-col>
                            <a-col :span="6">
                                <span style="font-weight:400;color:rgba(153,153,153,1);">指标名称：</span>
                            </a-col>

                            <a-col :span="14">
                                <span>ASLKDJNDJ</span>
                            </a-col>
                        </a-row>


                        <a-row class="row-bg" style="margin-top: 30px">
                            <a-col :span="2" :offset="1">
                                <img src="../../assets/image/home/icon_3.png" width="25px">
                            </a-col>
                            <a-col :span="6">
                                <span style="font-weight:400;color:rgba(153,153,153,1);">时段：</span>
                            </a-col>
                            <a-col :span="14">
                                <span>ASLKDJNDJ</span>
                            </a-col>
                        </a-row>


                        <a-row class="row-bg" style="margin-top: 30px">
                            <a-col :span="2" :offset="1">
                                <img src="../../assets/image/home/icon_4.png" width="25px">
                            </a-col>
                            <a-col :span="6">
                                <span style="font-weight:400;color:rgba(153,153,153,1);">指标值：</span>
                            </a-col>
                            <a-col :span="14">
                                <span>ASLKDJNDJ</span>
                            </a-col>
                        </a-row>

                        <a-row class="row-bg" style="margin-top: 30px">
                            <a-col :span="2" :offset="1">
                                <img src="../../assets/image/home/icon_5.png" width="25px">
                            </a-col>
                            <a-col :span="6">
                                <span style="font-weight:400;color:rgba(153,153,153,1);">考核基数：</span>
                            </a-col>
                            <a-col :span="14">
                                <span>ASLKDJNDJ</span>
                            </a-col>
                        </a-row>
                    </div>
                </a-card>
            </a-col>
        </a-row>
    </div>
</template>

<script>

    import Test from "@/components/test";
    var echarts = require('echarts');


    export default {
        name: "Home",
        components: {Test},
        data: function () {
            return {}
        },
        mounted: function () {
            var dom = document.getElementById("PerformanceCharts");
            var myChart = echarts.init(dom);
            var option = {
                legend: {},
                tooltip: {},
                dataset: {
                    dimensions: ['performance', '昨日绩效', '今日绩效'],
                    source: [
                        {performance: '存款绩效', '昨日绩效': 43.3, '今日绩效': 825.8},
                        {performance: '贷款绩效', '昨日绩效': 343.3, '今日绩效': 185.8},
                        {performance: '业务绩效', '昨日绩效': 43.3, '今日绩效': 285.8},
                    ]
                },
                xAxis: {type: 'category'},
                yAxis: {},
                // Declare several bar series, each will be mapped
                // to a column of dataset.source by default.
                series: [
                    {type: 'bar'},
                    {type: 'bar'}
                ]
            };
            if (option && typeof option === "object") {
                myChart.setOption(option, true);
            }
        }

    }
</script>

<style scoped>
    .ant-card-head-title {
        padding: 10px 0;
    }

    .a-card_body {
        padding: 15px;
    }

    .box-card {
        height: 100%;
    }
</style>