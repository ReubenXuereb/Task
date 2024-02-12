import os

# variables
passphrase_path = "secrets/"
prv_key_ca = "myCATest.key"
pem_file = "myCAPemTest.pem"
questions = "/C=MT/ST=MT/L=Valletta/O=ETPA/OU=Third-Party/CN=CarTraderApp.com"
prv_key_app = "privateKeyAppTest.key"
csr_file = "privateKeyAppTest.csr"
crt_file = "publicKeyTest.crt"
config_file_path = "configFile/csr.config"
pub_key_p12 = "publicKeyTest.p12"

# set executable variables
create_prv_key_for_ca = "openssl genrsa -des3 -passout file:" + passphrase_path + "passphrase.txt -out " + prv_key_ca + " 2048"
create_pem = 'openssl req -x509 -new -nodes -passin file:' + passphrase_path + 'passphrase.txt -key ' + prv_key_ca + ' -sha256 -days 365 -subj "'+ questions +'" -out ' + pem_file
create_prv_key_for_app = "openssl genrsa -out " + prv_key_app + " 2048"
create_csr_for_app = 'openssl req -new -key ' + prv_key_app + ' -subj "' + questions + '" -out ' + csr_file
create_pub_key = "openssl x509 -req -passin file:" + passphrase_path + "passphrase.txt -in " + csr_file + " -CA " + pem_file + " -CAkey " + prv_key_ca +" -CAcreateserial -out " + crt_file + " -days 365 -sha256 -extfile " + config_file_path + " -extensions v3_ca"
convert_crt_to_pkcs12 = "openssl pkcs12 -passout file:" + passphrase_path + "passphrase.txt -export -out " + pub_key_p12 + " -inkey " + prv_key_app + " -in " + crt_file


# run process

# Create private key for CA
os.system(create_prv_key_for_ca)

# Create CA:
os.system(create_pem)

# Create private key for Application
os.system(create_prv_key_for_app)

# Create signed certificate using the private key of the Application
os.system(create_csr_for_app)

# Create public key using config file
os.system(create_pub_key)

# Convert crt to pkcs12
os.system(convert_crt_to_pkcs12)
