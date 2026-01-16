This provides an LLD for Ride-Sharing-Applications(like Uber/Rapido/Ola)

It contains 3 test cases :
1. Happy Path (Rider successfully books a ride)
2. Ride Booking failed because of expired fare(TTL)
3. Concurrent Driver Object(2 Riders trying to book the same driver)

🛠 Design Patterns
1. Strategy Pattern: Used for FareCalculator and MatchDriver to allow swappable surge pricing and driver search algorithms without modifying core service logic.
2. Entity-Product Model: Decouples the physical Vehicle from the service type (UberGo, UberXL), allowing cars to belong to multiple product categories.

🚀 RideServiceImpl Logic
1. estimateFare: Calculates base price using Euclidean distance and adds dynamic surges based on time-based strategies.
2. createFare: Generates a "Price Lock" with a unique ID and timestamp, storing it in a ConcurrentHashMap for temporary price consistency.
3. requestRide: Validates the Fare TTL and performs an atomic "handshake" to finalize the driver-rider pairing.

🔒 Concurrency & TTL
1. TTL Validation: Compares System.currentTimeMillis() against the Fare creation time; if the 5-second window is exceeded, the booking is rejected.
2. Atomic Reservation: Uses AtomicBoolean.compareAndSet to ensure that if two riders target the same driver, only the first thread succeeds in marking them unavailable.

🧪 Test Scenarios
1. Case 1 (Happy Path): Confirms the end-to-end flow from location input to successful ride object creation.
2. Case 2 (TTL Expiry): Uses Thread.sleep to simulate a delay, proving the system rejects bookings with stale price quotes.
3. Case 3 (Concurrency): Uses CompletableFuture to run simultaneous requests, verifying that the system prevents double-booking a single driver.