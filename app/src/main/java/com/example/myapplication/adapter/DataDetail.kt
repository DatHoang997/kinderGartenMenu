data class DataDetail(val status: Boolean,
                      var name: String?="",
                      var des: String?= "",
                      var date: String?= null,
                      var listFood: List<DataDetail> ?= mutableListOf(),) {
}