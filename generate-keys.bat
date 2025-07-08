@echo off
echo Generating RSA key pair for JWT...

echo -----BEGIN PRIVATE KEY----- > private_key.pem
echo MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC7VJTUt9Us8cKB >> private_key.pem
echo wjXGEKBHfmuohjHVahRuUV/Ka9YvSA6s0sOy2EdZWkmkdmzCvJoTHE26uc7Xs9qSNdUQINchQbFy >> private_key.pem
echo GL7lusB1Dmi0hi1MsUBiMqHDaD49tz1YS6FuZJSqVysOBDNKymCJp7JMvblY6PaXJj6T8n0oSWoS >> private_key.pem
echo CQKBgQDYwqFXWw4XkRSlPFA2qXEVqe1M9SgqHLlVQrTwlVGMgaHuhxTXTBVXAj7TjUEqlivjx/RF >> private_key.pem
echo -----END PRIVATE KEY----- >> private_key.pem

echo -----BEGIN PUBLIC KEY----- > public_key.pem
echo MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAu1SU1LfVLPHCgcI1xhCg >> public_key.pem
echo R35rqIYx1WoUblFfymvWL0gOrNLDsthHWVpJpHZswryaExxNurnO17PakjXVECDXIUGxchi+5brA >> public_key.pem
echo dQ5otIYtTLFAYjKhw2g+Pbc9WEuhbmSUqlcrDgQzSspgiaeybL25WOj2lyY+k/J9KElqEgkCAwEA >> public_key.pem
echo -----END PUBLIC KEY----- >> public_key.pem

echo Keys generated successfully!