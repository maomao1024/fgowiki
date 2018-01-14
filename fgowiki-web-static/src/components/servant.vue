<template>
    <div>
        <el-table :data="servantInfo" height="800" border style="width: 100%">
            <el-table-column  label="头像">
                <template scope="scope">
                    <img :src="scope.row.image" width="100" height="100"/>
                </template>
            </el-table-column>
            <el-table-column  label="姓名">
                <template scope="scope">
                  {{ scope.row.nameZh }}
                </template>
            </el-table-column>
            <el-table-column label="阶职">
                <template scope="scope">
                  {{ scope.row.clazz.nameEn }}
                </template>
            </el-table-column>
            <el-table-column label="星级">
                <template scope="scope">
                    {{ scope.row.star }}
                </template>
            </el-table-column>
            <!--<el-table-column prop="image" label="姓名"/>
            <el-table-column prop="nameZh" label="姓名"/>
            <el-table-column prop="clazz.nameEn" label="阶职"/>
            <el-table-column prop="star" label="星级"/>-->
        </el-table>

        <div class="block">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[10, 20, 50, 100]"
                    :page-size="10"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="toatlSize">
            </el-pagination>
        </div>
    </div>
</template>

<script>
    export default {
        methods: {
            loadData: function (obj) {
                this.ajax.get('/api/servant/', {
                        params: {
                            pageNum: obj.pageNum - 1,
                            pageSize: obj.pageSize
                        },
                    },
                ).then(function (res) {
                    let data = res.data;
                    obj.servantInfo = data.content;
                    obj.servantInfo.forEach(o => o.image = '/static/img/servant/head/'+('000'+o.id).substr(-3)+'.jpg');
                    obj.pageNum = data.number + 1;
                    obj.toatlSize = data.totalElements;
                }).catch(function (err) {
                    console.log(err)
                });
            },
            handleSizeChange(val) {
                this.pageSize = val;
                this.loadData(this);
            },
            handleCurrentChange(val) {
                this.pageNum = val;
                this.loadData(this);
            }
        },
        data() {
            return {
                servantInfo: [],
                pageNum: 1,
                pageSize: 10,
                toatlSize: -1
            };
        },
        mounted() {
            this.loadData(this)
        }
    }

</script>