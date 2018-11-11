# ESlibForPaymentsHackweek2018
Elastic Search Library for payments 2018 hackweek, Lister project

# Connect to Elastic Search
Use `com.ebay.payments.hackweek.repo.ElasticSearchRepo<T>` to execute 'match query'.</br>
Sample URL: `https://eshost:9243/myindex/_search?q=field_name:field_val`. You just need pass field_name & field_val to me. We could discuss whether we need other sorts of query like fuzzy, multi-match, etc.
## How to use
Just include `com.ebay.payments.hackweek.Config` to your Spring Configuration and you could inject this repo to wherever you want.
## Integration test
An integration test `com.ebay.payments.hackweek.repo.ItemInfoRepoIT` to prove this one really works with the real ES. It would be automatically executed while maven building.

# List request
Here is a class `com.ebay.payments.hackweek.pojo.ListRequest`, most data could be reterived from ES. Client needs to fill it with seller info, additional attributres, etc.
## Sample list request
```
{
    "listingRequestedId": "5710372010",
    "listingCreationDate": "2016-01-06T19:49:38.000Z",
    "lineItems": [{
        "lineItemId": "1",
        "categoryId": "1234",
        "categoryName": "Cell Phones & Smartphones",
        "title": "Apple iPhone XS 256GB",
        "image": {
            "imageUrl": "http://pics.ebaystatic.com..."
        },
        "seller": {
            "username": "mark",
            "contactEmail": "testUser@qq.com"
        },
        "quantity": 1,
        "price": {
            "value": "10.00",
            "currency": "USD"
        },
        "itemCondition": "New",
        "description": "Apple iPhone XS 256GB - All Colors - GSM & CDMA UNLOCKED - BRAND NEW",
        "shippingDetail": {
            "shippingServiceCode": "USPS First Class Package",
            "shippingCarrierCode": "USPS",
            "minEstimatedDeliveryDate": "2016-01-09T08:00:00.783Z",
            "maxEstimatedDeliveryDate": "2016-01-13T08:00:00.783Z"
        }
    }],
    "paymentInstrument": {
        "paymentMethodType": "CREDIT_CARD"
    },
    "attributes": [{
        "Color": "Grey",
        "Size": "5.8-inch",
        "Band": "MODEL A1920"
    }]
}
```
