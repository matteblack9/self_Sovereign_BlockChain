from iconservice import *


class POST_Token(IconScoreBase):

    __USER_ADDRESS = 'user_address'
    __ISSUERS = 'issuers'

    def __init__(self, db: IconScoreDatabase) -> None:
        super().__init__(db)

        self.__users_address = DictDB(self.__USER_ADDRESS, db, value_type=str, depth=1) # default = 1
        self.__issuers = DictDB(self.__ISSUERS, db, value_type=str, depth=1) # default = 1

    def on_install(self) -> None:
        super().on_install()

    def on_update(self) -> None:
        super().on_update()
    
    @external(readonly=True)
    def get_my_claims(self) -> str:
        claims = self.__get_array_of(str(self.msg.sender))
        for e in claims:
            print(e)
        return "get_my_claims"

    @external
    def add_claim(self, claim: str):
        print(claim)
        print(self.__get_array_of(str(self.msg.sender)).put(claim))

    def __get_array_of(self, address: str):
        return ArrayDB(address, self.db, value_type=str)

    @external
    def add_new_user(self, public_key: str):
        if self.__users_address[str(self.msg.sender)] == 0: # not existed
            self.__users_address[str(self.msg.sender)] = public_key
            return "OK"
        else:
            return "FAILURE"

    @external
    def add_new_issuers(self, public_key: str):
        if self.__issuers[str(self.msg.sender)] == 0: # not existed
            self.__issuers[str(self.msg.sender)] = public_key
            return "OK"
        else:
            return "FAILURE"

    @external(readonly=True)
    def get_user_public_key(self, user_address):
        key = self.__users_address[str(user_address)]
        if key == 0:
            return "FAILURE"
        else:
            return key

    @external(readonly=True)
    def get_issuer_public_key(self, issuer_address):
        key = self.__issuers[str(issuer_address)]
        if key == 0:
            return "FAILURE"
        else:
            return key


