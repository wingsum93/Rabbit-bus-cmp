package org.ericho.recipeappcmp.data.remote

import io.ktor.client.HttpClient
import kotlinx.coroutines.test.runTest
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


class BusRemoteDataSourceTest : KoinTest {
    private val ALL_ROUTE_JSON = readResourceFile("mocks/all_route.json")
    private val ROUTE_6C_INBOUND_JSON = readResourceFile("mocks/route_6c_inbound.json")
    private val ROUTE_6C_OUTBOUND_JSON = readResourceFile("mocks/route_6c_outbound.json")

    private val ALL_STOP_JSON = readResourceFile("mocks/all_stop.json")
    private val STOP_F0AC02C6C94078C4_JSON = readResourceFile("mocks/stop_F0AC02C6C94078C4.json")

    private val ALL_ROUTE_STOPS_JSON = readResourceFile("mocks/all_route_stops.json")
    private val testModule = module {
        single<BusRemoteDataSource> { BusRemoteDataSourceImpl(get()) }
        single<HttpClient> {
            createMockHttpClient(
                mapOf(
                    "/route/" to ALL_ROUTE_JSON,
                    "/route/6C/inbound/1" to ROUTE_6C_INBOUND_JSON,
                    "/route/6C/outbound/1" to ROUTE_6C_OUTBOUND_JSON,

                    "/stop" to ALL_STOP_JSON,
                    "/stop/F0AC02C6C94078C4" to STOP_F0AC02C6C94078C4_JSON,

                    "/route-stop" to ALL_ROUTE_STOPS_JSON
                )
            )
        }
    }

    @BeforeTest
    fun setup() {
        startKoin { modules(testModule) }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    private val dataSource: BusRemoteDataSource by inject()

    @Test
    fun testGetAllRoute() = runTest {
        val routeItems = dataSource.getAllRoutes().getOrThrow()

        // Compare values
        assertEquals(1564, routeItems.size)
        assertEquals("KOWLOON CITY FERRY", routeItems[12].origEn)
    }

    @Test
    fun testGetRoute_6C_inbound() = runTest {
        val routeItem = dataSource.getBusRoute("6C", "inbound", "1").getOrThrow()
        // Compare values
        assertEquals("6C", routeItem.route)
        assertEquals("MEI FOO", routeItem.origEn)
    }

    @Test
    fun testGetRoute_6C_outbound() = runTest {
        val routeItem = dataSource.getBusRoute("6C", "outbound", "1").getOrThrow()
        // Compare values
        assertEquals("6C", routeItem.route)
        assertEquals("KOWLOON CITY FERRY", routeItem.origEn)
    }

    @Test
    fun testGetAllStops() = runTest {
        val stopItems = dataSource.getAllStops().getOrThrow()

        // Compare values
        assertEquals(6645, stopItems.size)
        assertEquals("D7EDDEA5A942843B", stopItems[123].id)
        assertEquals(22.324574, stopItems[123].latitude)
        assertEquals(114.185031, stopItems[123].longitude)
    }

    @Test
    fun testGetStop_F0AC02C6C94078C4() = runTest {
        val stopItem = dataSource.getStop("F0AC02C6C94078C4").getOrThrow()

        // Compare values
        assertEquals("F0AC02C6C94078C4", stopItem.id)
        assertEquals("WONG TAI SIN POLICE STATION (WT329)", stopItem.nameEn)
        assertEquals(22.339447, stopItem.latitude)
        assertEquals(114.197681, stopItem.longitude)
    }

    @Test
    fun testGetAllRouteStops() = runTest {
        val routeStops = dataSource.getAllRouteStops().getOrThrow()

        // Compare values
        assertEquals(35381, routeStops.size)
        assertEquals("1A", routeStops[111].route)
        assertEquals("D3FEF85E4DAEEE4E", routeStops[111].stopId)
        assertEquals("I", routeStops[111].direction)
    }
}