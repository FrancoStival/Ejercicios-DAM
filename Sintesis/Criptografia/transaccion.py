import Cifrado.dsa as dsa


class Transaction:

    def __init__(self, sender_public_key, receiver, amount, signature=None):
        self.sender_public_key = sender_public_key
        self.receiver = receiver
        self.amount = amount
        self.signature = signature

    def to_string(self):
        return f"{self.sender_public_key}{self.receiver}{self.amount}"

    def sign_transaction(self, private_key):
        mensaje = self.to_string()

        p, q, g, y = self.sender_public_key

        self.signature = dsa.firmar(
            mensaje,
            (p, q, g),
            private_key
        )

    def is_valid(self):
        if self.signature is None:
            return False

        mensaje = self.to_string()

        return dsa.verificar(
            mensaje,
            self.signature,
            self.sender_public_key
        )