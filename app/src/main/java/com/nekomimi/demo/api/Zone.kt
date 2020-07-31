package com.nekomimi.demo.api

class Zone : ArrayList<Zone.ZoneItem>(){
    data class ZoneItem(
        val brackets: Brackets,
        val encounters: List<Encounter>,
        val frozen: Boolean,
        val id: Int,
        val name: String,
        val partitions: List<Partition>
    ) {
        data class Brackets(
            val bucket: Double,
            val max: Double,
            val min: Int,
            val type: String
        )
    
        data class Encounter(
            val id: Int,
            val name: String
        )
    
        data class Partition(
            val area: Int,
            val compact: String,
            val default: Boolean,
            val name: String
        )
    }
}