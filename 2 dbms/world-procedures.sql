USE world;

DELIMITER //

CREATE PROCEDURE update_percentage (IN countryCode VARCHAR(3), IN newPercentage DECIMAL(4,1))
BEGIN
    UPDATE countrylanguage
    SET Percentage = newPercentage
    WHERE CountryCode = countryCode;
END//

CREATE PROCEDURE get_country_language_info (
    IN inCountryCode VARCHAR(3),
    OUT officialLanguageCount INT,
    OUT totalLanguageCount INT,
    OUT officialLanguagePercentage DECIMAL(4,1)
)
BEGIN
    -- Total no. of official languages
    SELECT COUNT(*) INTO officialLanguageCount
    FROM countrylanguage
    WHERE CountryCode = inCountryCode AND IsOfficial = 'T';

    -- Total number of languages
    SELECT COUNT(*) INTO totalLanguageCount
    FROM countrylanguage
    WHERE CountryCode = inCountryCode;

    -- Total percentage of population speaking official language
    SELECT SUM(Percentage) INTO officialLanguagePercentage
    FROM countrylanguage
    WHERE CountryCode = inCountryCode AND IsOfficial = 'T';
END//

DELIMITER ;
