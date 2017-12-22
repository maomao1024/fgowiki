<template>
    <el-table
            :data="servantInfo"
            height="80%"
            border
            style="width: 100%">
        <el-table-column
                prop="nameZh"
                label="姓名">
        </el-table-column>
        <el-table-column
                prop="clazz.nameEn"
                label="阶职">
        </el-table-column>
        <el-table-column
                prop="star"
                label="星级">
        </el-table-column>
    </el-table>
</template>

<script>
	export default {
		data() {
				this.ajax.get('http://127.0.0.1:8080/servant/',
					{
						pageNum: 0,
						pageSize: 15
					},
				).then(function (res) {
					console.log(res);
					return {servantInfo: res.content}
				}).catch(function (err) {
					console.log(err)
				});

			return {servantInfo: []}
		},
		methods: {
			refresh() {
				this.ajax.get('http://127.0.0.1:8080/servant/',
					{
						pageNum: 0,
						pageSize: 15
					},
				).then(function (res) {
					console.log(res);
					//this.servantInfo = res.content;
				}).catch(function (err) {
					console.log(err)
				});
			}
		}
	}
</script>