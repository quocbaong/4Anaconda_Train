load  csv with headers from 'file:///zips.csv' as row
create (z:Zip{code:row.code})
set z.city=row.city,
z.loc = point({x:toFloat(row.`lox/x`), y:toFloat(row.`loc/y`)}),
z.pop = toInteger(row.pop),
z.state = row.state;

MATCH(n:Zip) RETURN n LIMIT 20;
CREATE CONSTRAINT UQ_ZIP_CODE FOR (n:Zip) REQUIRE n.code IS UNIQUE;
show CONSTRAINT
MATCH (n:Zip) RETURN n LIMIT 5
CREATE (z:Zip {code: "1006", city: "NEW CITY", state: "NY", pop: 5000})
RETURN z;

MATCH (z:Zip {code: "1006"}) RETURN z;
MATCH (z:Zip {code: '1006'}) SET z.city = 'New City', z.pop = 50000;
MATCH (z:Zip {code: '1006'}) DETACH DELETE z;
MATCH (z:Zip) DETACH DELETE z;
MATCH (z:Zip {city: 'PALMER'}) RETURN z;
MATCH (z:Zip) WHERE z.pop > 100000 RETURN z;
MATCH (z:Zip {city: 'FISHERS ISLAND'}) RETURN z.pop;
MATCH (z:Zip) WHERE z.pop >= 10 AND z.pop <= 50 RETURN z.city;
MATCH (z:Zip) WHERE z.state = 'MA' AND z.pop > 500 RETURN z.city;
MATCH (z:Zip) RETURN DISTINCT z.state;
MATCH (z:Zip) RETURN z.state, avg(z.pop) AS avg_pop;
MATCH (z:Zip) WHERE z.state = 'CT' AND z.city = 'WATERBURY' RETURN z;
MATCH (z:Zip) WHERE z.state = 'WA' RETURN COUNT(DISTINCT z.city) AS city_count;
MATCH (z:Zip) RETURN z.state, SUM(z.pop) AS total_pop ORDER BY total_pop DESC;
MATCH (z:Zip) RETURN z.state, SUM(z.pop) AS total_pop WHERE total_pop > 10000000;
MATCH (z:Zip) RETURN z ORDER BY z.pop DESC LIMIT 1;
MATCH (z:Zip) RETURN z ORDER BY z.pop ASC LIMIT 1;
MATCH (z:Zip) RETURN z.state, SUM(z.pop) AS total_pop ORDER BY total_pop DESC LIMIT 1;
MATCH (z:Zip) RETURN z.state, SUM(z.pop) AS total_pop ORDER BY total_pop ASC LIMIT 1;