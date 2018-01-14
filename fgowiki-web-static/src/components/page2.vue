<template>
    <el-table :data="tableData" border style="width: 100%">
        <el-table-column label="图片" width="180">
            <template scope="scope">
                <img :src="scope.row.image" width="100" height="100"/>
            </template>
        </el-table-column>
        <el-table-column label="姓名" width="180">
            <template scope="scope">
                <el-popover trigger="hover" placement="top">
                    <p>姓名: {{ scope.row.name }}</p>
                    <p>住址: {{ scope.row.address }}</p>
                    <div slot="reference" class="name-wrapper">
                        <el-tag>{{ scope.row.name }}</el-tag>
                    </div>
                </el-popover>
            </template>
        </el-table-column>
        <el-table-column label="操作"></el-table-column>
    </el-table>
</template>
<script>
    export default {

        data() {
            return {
                tableData: [{
                    image: 'https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=1a3d82d42f2dd42a4b0409f9625230d0/314e251f95cad1c86a912b9a753e6709c93d5161.jpg',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1518 弄'
                }, {
                    image: 'https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=1a3d82d42f2dd42a4b0409f9625230d0/314e251f95cad1c86a912b9a753e6709c93d5161.jpg',
                    name: '王小虎',
                    address: '上海市普陀区金沙江路 1517 弄'
                }]
            }
        },
        methods: {
            handleEdit(index, row) {
                console.log(index, row);
            },
            handleDelete(index, row) {
                console.log(index, row);
            }
        }
    }</script>