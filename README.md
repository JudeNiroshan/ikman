# ikman 
Advertisement API with MySQL📚 + Spring-Boot 🚀

This API is developed with the intention of following the best practices 
for RESTFul APIs. It has own MySQL database to save real world advertisements.
Following endpoints are available as of now:
- `/ads` - Return all ads
- `/category/all` - Return all categories
- `/ads/category/{categoryName}` - Return all ads classified by the given `categoryName`

Completed Tasks:
 - 
 ✅ Use only Java code to generate entire database(no `.sql` scripts are needed)
 
 ✅ Load real advertisements(Only 25) from external systems every time API server is starting up
 
 
Future Tasks:
 - 
 ⭕ Integrate swagger UI
 
 ⭕ create DockerFile.yml
 
 ⭕ Delete ads older than 1 week(using a scheduler within the API server)
 
 ⭕ Fetch Ads descriptions and more important data for each ad 🔁
 
 ⭕ Scrap ads from external systems by the categories and save them
 
 ⭕ Segregate identities for different element tags in external systems
 
 ⭕ Create API user accounts to run saved queries for given criteria
 
 
 
