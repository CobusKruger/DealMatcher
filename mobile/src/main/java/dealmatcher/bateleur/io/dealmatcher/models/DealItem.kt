package dealmatcher.bateleur.io.dealmatcher.models

import java.util.logging.Filter

data class DealItemRating(
        val count: Int,
        val average: Double
)

data class DealItem(
        val rating: DealItemRating,
        val title: String,
        val subtitle: String,
        val selling_price: Double,
        val old_selling_price: Double,
        val saving: String,
        val id: Int,
        val uuid: String,
        val uri: String,
        val description: String,
        val images: Array<String>,
        val price: Double,
        val discount: Double
)

data class TakealotParameters(
        val sort: Array<String>?,
        val return_breadcrumb_enabled: Array<String>?,
        val return_filters_enabled: Array<String>?,
        val rows: Array<String>?,
        val detail: Array<String>?,
        val filter: Array<String>?,
        val start: Array<String>?,
        val version: Array<String>?,
        val return_facets_enabled: Array<String>?
)

data class TakealotFacetEntry(
        val filter: String,
        val display_name: Boolean,
        val name: Boolean,
        val num_docs: Int
)

data class TakealotFacet(
        val display_name: String?,
        val type: String,
        val name: String,
        val entries: Array<TakealotFacetEntry>
)

data class TakealotResults(
        val breadcrumbs: Array<String>?,
        val facets: Array<TakealotFacet>?,
        val start: Int = 0,
        val productlines: Array<DealItem>
)

data class TakealotResponse(
        val backend: String,
        val params: TakealotParameters,
        val uuid: String,
        val results: TakealotResults
)