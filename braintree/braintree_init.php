<?php


session_start();
require_once ("lib/autoload.php");
if(file_exists(__DIR__ . "/../.env"))
{
	$dotenv = new Dotenv\Dotenv(__DIR__ . "/../");
	$dotenv->load();
}

Braintree_Configuration::environment('sandbox');
Braintree_Configuration::merchantId('6x572nfzprnxd574');
Braintree_Configuration::publicKey('8bv9t8j38xvvgzpy');
Braintree_Configuration::privateKey('690763dcd317cd894e7bb5508f806ac8');

?>